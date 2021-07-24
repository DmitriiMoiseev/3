package ru.geekbrains.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findByProductnameStartsWith(String prefix);
    List<Product> findByPrice(Integer prefix);

}
