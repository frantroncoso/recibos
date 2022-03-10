package com.example.demo.models;


import com.example.demo.daos.UserDAO;
import com.example.demo.vo.UserVO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private Integer dni;
    private String estadoCivil;
    private String mail;
    private Integer telefono;
    private String password;

    //private List<Recibo> recibos;

    public User(){}

    public User(Integer id, String nombre, String apellido, LocalDate fechaNac, Integer dni, String estadoCivil, String mail, Integer telefono, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
        this.mail = mail;
        this.telefono = telefono;
        this.password = password;
        //this.recibos = recibos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return new UserVO(this.id, this.nombre, this.apellido, this.fechaNac, this.dni, this.estadoCivil, this.mail, this.telefono, this.password);
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

    /*public List<Recibo> getMisRecibos() throws Exception {
        return ReciboDAO.getInstancia().
    }*/
}
