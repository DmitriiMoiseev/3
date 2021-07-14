package ru.geekbrains.entity;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao {


//    Создайте класс ProductDao
//    и реализуйте в нем логику выполнения CRUD-операций над сущностью Product
//    (Product findById(Long id),
//    List"Product" findAll(),
//    void deleteById(Long id),
//    Product saveOrUpdate(Product product)).

    public Product findById(EntityManager em, Long id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    public List<Product> findAll(EntityManager em) {
        List<Product> products = em.createQuery("select p from Product p", Product.class)
                .getResultList();
        return products;
    }

    public void deleteById(EntityManager em, Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }

    public void saveOrUpdate(EntityManager em, Product product) {
        Long id = product.getId();
        if(id == null) {
            em.persist(product);
        } else {
            em.merge(product);
        }
    }
}
