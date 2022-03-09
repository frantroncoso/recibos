package com.example.demo.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EManager {
    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        return factory.createEntityManager();
    }
}
