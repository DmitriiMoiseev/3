package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long> {

    List<Product> findByProductnameStartsWith(String prefix);
    List<Product> findByPrice(String prefix);

}
