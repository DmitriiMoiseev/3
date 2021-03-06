package ru.geekbrains.geekbrains;

import ru.geekbrains.geekbrains.persist.Product;
import ru.geekbrains.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        ProductRepository productRepository = new ProductRepository();
        productRepository.save(new Product(1L, "Product-1"));
        productRepository.save(new Product(2L, "Product-2"));
        productRepository.save(new Product(3L, "Product-3"));

        sc.setAttribute("productRepository", productRepository);
    }
}
