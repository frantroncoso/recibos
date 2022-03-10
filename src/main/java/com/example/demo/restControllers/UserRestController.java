package com.example.demo.restControllers;

import com.example.demo.controladores.UserController;
import com.example.demo.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class UserRestController {

    @PostMapping("/createUser")
    public void createUser(
            @RequestParam(name="nombre") String nombre,
            @RequestParam(name="apellido") String apellido,
            @RequestParam(name="fechaNac") LocalDate fechaNac,
            @RequestParam(name="dni") Integer dni,
            @RequestParam(name="estadoCivil") String estadoCivil,
            @RequestParam(name="mail") String mail,
            @RequestParam(name="telefono") Integer telefono,
            @RequestParam(name= "password") String password
            ){
        try {
            UserController.getInstancia().createUser(nombre, apellido, fechaNac, dni, estadoCivil, mail, telefono, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestParam(name="userId") int userId, @RequestParam(name="password") String password){
        try {
            UserController.getInstancia().updateUser(userId,password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/deleteUserById")
    public void deleteUserById(@RequestParam(name="userId") int userId){
        try {
            UserController.getInstancia().deleteUser(userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping("/getUserById")
    public UserVO getUserById(@RequestParam(name="userId") int userId){
        try {
            return UserController.getInstancia().getUserById(userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping("/getUsuarioByIdAndPassword")
    public UserVO getUsuarioByIdAndPassword(@RequestParam(name="dni") int dni, @RequestParam(name="password") String password) throws Exception {
        return UserController.getInstancia().getUsuarioByIdAndPassword(dni,password);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return e.getMessage();
    }

    @RequestMapping("/getAllUsuarios")
    public List<UserVO> getAllUsuarios() throws Exception {
        return UserController.getInstancia().getAllUsuarios();
    }

}
