package com.example.demo.daos;

import com.example.demo.entityManager.EManager;
import com.example.demo.models.User;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.List;

public class UserDAO {

    private static UserDAO instancia;

    private UserDAO(){}

    public static UserDAO getInstancia(){
        if (instancia == null){
            instancia = new UserDAO();
        }
        return instancia;
    }

    public void createUser(User user) throws Exception {
        try {
            EntityManager em = EManager.getEntityManager();
            em.getTransaction().begin();
            em.persist(user);

            em.getTransaction().commit();
            em.close();
        } catch(EntityExistsException e){
            throw new Exception("The entity already exists");
        } catch (IllegalArgumentException e){
            throw new Exception("The instance is not a entity");
        }

    }

    public User getUserByDni(int dni) throws Exception {
        try {
            EntityManager em = EManager.getEntityManager();
            User user = (User) em.createQuery("FROM User u WHERE u.dni ="+dni).getSingleResult();
            em.close();
            return user;
        } catch(NoResultException e){
            throw new Exception("No existe el usuario");
        }
    }

    public void updateUser(User user) throws Exception {
        try{
            EntityManager em = EManager.getEntityManager();
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            em.close();
        } catch(IllegalArgumentException e){
            throw new Exception("The instance is not an entity or is a removed entity");
        }

    }

    public void deleteUser(User user) throws Exception {
        try {
            EntityManager em = EManager.getEntityManager();
            em.getTransaction().begin();
            em.remove(em.contains(user) ? user : em.merge(user));
            em.getTransaction().commit();
            em.close();
        } catch (IllegalArgumentException e){
            throw new Exception("The instance is not an entity or is a detached entity");
        }

    }

    public User getUserById(int userId) throws Exception {
        try {
            EntityManager em = EManager.getEntityManager();
            User user = em.find(User.class, userId);
            em.close();
            return user;
        } catch(EntityNotFoundException e){
            throw new Exception("User not found with userId "+userId);
        }

    }

    public List<User> getAllUsuarios() throws Exception {
        try {
            EntityManager em = EManager.getEntityManager();
            List<User> usuarios = em.createQuery("FROM User").getResultList();
            em.close();
            return usuarios;
        } catch(NoResultException e){
            throw new Exception("No hay tipos de estudios cargados");
        }
    }
}
