package com.example.demo.testControllers;

import com.example.demo.controladores.UserController;
import com.example.demo.entityManager.EManager;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class TestUserController extends TestCase {

    public void testCreateUser() {

        try {
            SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");
            UserController.getInstancia().createUser("Juan", "Troncoso", LocalDate.of(1999, 05, 21), 43248753, "Soltero", "frantron01@gmail.com", 1154879632, "prueba");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

