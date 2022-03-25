package com.example.demo.models;


import com.example.demo.daos.ReciboDAO;
import com.example.demo.daos.UserDAO;
import com.example.demo.vo.UserVO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Integer dni;
    private String estadoCivil;
    private String mail;
    private Integer telefono;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recibo> recibos;

    public User(){}

    public User(String nombre, String apellido, LocalDate fechaNac, Integer dni, String estadoCivil, String mail, Integer telefono, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
        this.mail = mail;
        this.telefono = telefono;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setId(Integer userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserVO toVO(){
        return new UserVO(this.userId, this.nombre, this.apellido, this.fechaNac, this.dni, this.estadoCivil, this.mail, this.telefono, this.password);
    }
    public List<Recibo> getMisRecibos() throws Exception {
        return ReciboDAO.getInstancia().getRecibosByUserId(this.getUserId());
    }

    public void save() throws Exception {
        UserDAO.getInstancia().createUser(this);
    }

    public void update() throws Exception {
        UserDAO.getInstancia().updateUser(this);
    }

    public void delete() throws Exception {
        UserDAO.getInstancia().deleteUser(this);
    }
}
