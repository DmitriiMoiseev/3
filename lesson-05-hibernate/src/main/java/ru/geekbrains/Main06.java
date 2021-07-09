package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.dao.ClientDao;
import ru.geekbrains.entity.Client;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main06 {

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ClientDao clientDao = new ClientDao(emFactory);
        ProductDao productDao = new ProductDao(emFactory);

        clientDao.printAllProductsOfClient(1L);
        productDao.printAllClientsOfProduct(1L);

//        EntityManager em = emFactory.createEntityManager();
//
//        em.getTransaction().begin();
//
//        Client client1 = new Client(null, "client1");
//        Client client2 = new Client(null, "client2");
//
//        Product product1 = new Product(null, "product1", 10L, client1);
//        Product product2 = new Product(null, "product2", 20L, client1);
//        Product product3 = new Product(null, "product3", 30L, client1);
//        Product product4 = new Product(null, "product4", 40L, client2);
//        Product product5 = new Product(null, "product5", 50L, client2);
//
//        client1.getProductList().add(product1);
//        client1.getProductList().add(product2);
//        client1.getProductList().add(product3);
//        client2.getProductList().add(product4);
//        client2.getProductList().add(product5);
//
//        em.persist(client1);
//        em.persist(client2);
//
//        em.getTransaction().commit();
//        em.close();

    }

}
