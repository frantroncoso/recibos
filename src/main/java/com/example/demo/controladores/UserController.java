package com.example.demo.controladores;

import com.example.demo.daos.UserDAO;
import com.example.demo.models.User;
import com.example.demo.vo.UserVO;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

public class UserController {

    private static UserController instancia;

    private UserController (){}

    public static UserController getInstancia(){
        if (instancia == null){
            instancia = new UserController();
        }
        return instancia;
    }

    public void createUser(String nombre, String apellido, LocalDate fechaNac, Integer dni, String estadoCivil, String mail, Integer telefono, String password) throws Exception {
        String salt = BCrypt.gensalt(12);
        String hashed_password = BCrypt.hashpw(password, salt);
        if(!existeUsuario(dni, password)){
            User newUser = new User(nombre, apellido, fechaNac, dni, estadoCivil, mail, telefono, hashed_password);
            newUser.save();
        } else {
            throw new Exception("Ya existe el usuario con estos datos");
        }
    }

    public void updateUser(int userId, String pass) throws Exception {
        User user = UserDAO.getInstancia().getUserById(userId);
        user.setPassword(pass);
        user.update();
    }

    public void deleteUser(int userId) throws Exception {
        User user = UserDAO.getInstancia().getUserById(userId);
        user.delete();
    }

    public UserVO getUserById(int userId) throws Exception {
        return UserDAO.getInstancia().getUserById(userId).toVO();
    }

    public UserVO getUsuarioByIdAndPassword(int dni, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User u = null;
        try {
            u = UserDAO.getInstancia().getUserByDni(dni);
            if (BCrypt.checkpw(password,u.getPassword())){
                return u.toVO();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public boolean existeUsuario(int dni, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User u = null;
        try {
            u = UserDAO.getInstancia().getUserByDni(dni);
            if (BCrypt.checkpw(password,u.getPassword())){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
