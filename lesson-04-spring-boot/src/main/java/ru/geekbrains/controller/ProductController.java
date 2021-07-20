package ru.geekbrains.controller;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;
import ru.geekbrains.persist.ProductSpecification;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listPage(Model model,
                           @RequestParam("productnameFilter")Optional<String> productnameFilter,
                           @RequestParam("priceFilter")Optional<String> priceFilter,
                           @RequestParam("page")Optional<Integer> page,
                           @RequestParam("size")Optional<Integer> size,
                           @RequestParam("sortField") Optional<String> sortField) {
        logger.info("Product list page requested");

//        List<Product> products;
//        if (productnameFilter.isPresent()) {
//            products = productRepository.findByProductnameStartsWith(productnameFilter.get());
//        } else if (priceFilter.isPresent()) {
//            products = productRepository.findByPrice(priceFilter.get());
//        } else if (productnameFilter.isPresent() && priceFilter.isPresent()) {
//            products = productRepository.findByProductnameStartsWith(productnameFilter.get());
//            products = productRepository.findByPrice(priceFilter.get());
//        } else {
//            products = productRepository.findAll();
//        }
//
//        model.addAttribute("products", products);

        Specification<Product> spec = Specification.where(null);
        if (productnameFilter.isPresent() && !productnameFilter.get().isBlank()) {
            spec = spec.and(ProductSpecification.productnamePrefix(productnameFilter.get()));
        }
        if (priceFilter.isPresent() && !priceFilter.get().isBlank()) {
            spec = spec.and(ProductSpecification.price(priceFilter.get()));
        }

        model.addAttribute("products", productRepository.findAll(spec,
                PageRequest.of(page.orElse(1) - 1, size.orElse(3),
                        Sort.by(sortField.orElse("id")))));

        return "products";
//
//         вместо if else
//        List<Product> products = productnameFilter
//                .map(productRepository::findByProductnameStartsWith)
//                .orElseGet(productRepository::findAll);
//
//        model.addAttribute("products", products);
//        return "products";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        logger.info("New product page requested");

        model.addAttribute("product", new Product());
        return "product_form";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        logger.info("Edit page for id {} requested", id);

        model.addAttribute("product", productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found")));

        return "product_form";
    }

    @PostMapping
    public String update(@Valid Product product, BindingResult result) {
        logger.info("Saving product");

        if (result.hasErrors()) {
            return "product_form";
        }

        productRepository.save(product);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        logger.info("Deleting product with id {}", id);

        productRepository.deleteById(id);
        return "redirect:/product";
    }

//    @ResponseStatus(HttpStatus.NOT_FOUND))
    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
