package ru.geekbrains;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.dao.ClientDao;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main05 {
    public static void main(String[] args) {

//        EntityManagerFactory emFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//
//        ProductDao productDao = new ProductDao(emFactory);
//
//        Product product = productDao.findById(em, 4L);
//        System.out.println(product);
//
//        List<Product> products;
//        products = productDao.findAll(em);
//        System.out.println(products);
//
//        productDao.deleteById(em, 8L);
//
//        Product product11 = new Product(8L, "product 5", 50L);
//        productDao.saveOrUpdate(em, product11);
//
//        em.getTransaction().commit();
//
//        em.close();

//        ==============================================================
//        INSERT
//        List.of(
//                new Product(null, "product1", 145L),
//                new Product(null, "product2", 150L),
//                new Product(null, "product3", 135L),
//                new Product(null, "product4", 80L),
//                new Product(null, "product5", 90L),
//                new Product(null, "product6", 35L),
//                new Product(null, "product7", 40L)
//        ).forEach(em :: persist);

//        SELECT
//        Product product = em.find(Product.class, 1L);
//        System.out.println(product);
//
//        HQL, JPQL (вместо SQL)
//        List<Product> products = em.createQuery("select p from Product p", Product.class)
//                .getResultList();
//        System.out.println(products);

//        List<Product> products = em.createQuery("select p from Product p where p.price <100", Product.class)
//                .getResultList();
//        System.out.println(products);
////        тот же запрос, но черз формирование параметра
//        List<Product> products = em.createQuery("select p from Product p where p.price < :price", Product.class)
//                .setParameter("price", 100)
//                .getResultList();
//        System.out.println(products);
//
//        Long countProduct = em.createNamedQuery("countProduct", Long.class).getSingleResult();
//        System.out.println(countProduct);

//        SQL
//        List resultList = em.createNativeQuery("select * from products", Product.class)
//                .getResultList();
//        System.out.println(resultList);

//        UPDATE 1 way
//        em.createQuery("update Product set price = 85 where id = 1")
//                .executeUpdate();

//        UPDATE 2 way
//        Product product = em.find(Product.class, 2L);
//        product.setPrice(90L);

//        UPDATE 3 way
//        Product product = new Product(1L, "product1", 65L);
//        em.merge(product);

//        DELETE 1 way
//        Product product = em.find(Product.class, 7L);
//        em.remove(product);

//        DELETE 2 way
//        Product product = em.getReference(Product.class, 6L);
//        em.remove(product);

    }
}
