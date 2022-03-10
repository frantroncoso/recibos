package com.example.demo.daos;

import com.example.demo.entityManager.EManager;
import com.example.demo.models.Recibo;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.List;

public class ReciboDAO {
    private static ReciboDAO instancia;

    private  ReciboDAO(){}

    public static ReciboDAO getInstancia(){
        if(instancia == null){
            instancia = new ReciboDAO();
        }
        return instancia;
    }

    public void crearRecibo(Recibo recibo) throws Exception{
        try {
            EntityManager em = EManager.getEntityManager();
            em.getTransaction().begin();
            em.persist(recibo);
            em.getTransaction().commit();
            em.close();
        }catch (EntityExistsException e){
            throw new Exception("The entity already exists");
        }catch (IllegalArgumentException e){
            throw  new Exception("The instance is not a entity");
        }
    }

    public void eliminarRecibo(Recibo recibo) throws Exception{
        try {
            EntityManager em = EManager.getEntityManager();
            em.getTransaction().begin();
            em.remove(em.contains(recibo) ? recibo : em.merge(recibo));
            em.getTransaction().commit();
            em.close();
        }catch (IllegalArgumentException e){
            throw new Exception("The instance is not an entity or is a detached entity");
        }
    }

    public List<Recibo> getRecibosByUserId(int userId) throws Exception{
        try {
            EntityManager em = EManager.getEntityManager();
            List<Recibo> recibos = em.createQuery("FROM Recibos r WHERE r.userId = '" + userId + "' ORDER BY r.fecha DESC").getResultList();
            em.close();
            return recibos;
        }catch (NoResultException e){
            throw new Exception("El usuario "+ userId +" no tiene recibos");
        }
    }
    public Recibo getReciboById(int reciboId) throws Exception {
        try {
            EntityManager em = EManager.getEntityManager();
            Recibo tipo = em.find(Recibo.class, reciboId);
            em.close();
            return tipo;
        } catch(EntityNotFoundException e){
            throw new Exception("Tipo not found with id " + reciboId);
        }

    }
}
