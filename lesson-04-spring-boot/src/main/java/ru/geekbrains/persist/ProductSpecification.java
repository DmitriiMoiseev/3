package ru.geekbrains.persist;

import org.springframework.data.jpa.domain.Specification;

public final class ProductSpecification {

    public static Specification<Product> productnamePrefix(String prefix){
        return (root, query, builder) -> builder.like(root.get("productname"), prefix + "%");
    }

    public static Specification<Product> price(String priceFilter) {
        return (root, query, builder) -> builder.like(root.get("price"), priceFilter);
    }


}
