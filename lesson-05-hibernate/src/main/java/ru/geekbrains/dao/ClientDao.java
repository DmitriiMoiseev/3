package ru.geekbrains.dao;

import ru.geekbrains.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ClientDao {

    EntityManagerFactory emFactory;

    public ClientDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public void printAllProductsOfClient(Long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Client client = em.find(Client.class, id);
        System.out.println(client);
        em.close();
    }
}
