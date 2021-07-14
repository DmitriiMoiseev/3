package ru.geekbrains.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProductDao {

    EntityManagerFactory emFactory;

    public ProductDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public Product findById(Long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }

    public List<Product> findAll() {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        List<Product> products = em.createQuery("select p from Product p", Product.class)
                .getResultList();
        em.close();
        return products;
    }

    public void deleteById(Long id) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        em.remove(product);
        em.close();
    }

    public void saveOrUpdate(Product product) {
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Long id = product.getId();
        if(id == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
        em.close();
    }

    public void printAllClientsOfProduct(Long id){
        EntityManager em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        System.out.println(product);
        em.close();
    }


}
