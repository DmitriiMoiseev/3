package ru.geekbrains.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "allProduct", query = "select p from Product p"),
        @NamedQuery(name = "productWithPriceBetween", query = "select p from Product p where p.price between :min and :max"),
        @NamedQuery(name = "countProduct", query = "select count(p) from Product p")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 512, nullable = false)
    private String productname;

    @Column(nullable = false)
    private Long price;

    @JoinColumn(name = "clientId")
    @ManyToOne
    private Client client;

//    @Transient - если не хочется мапить поле в таблице

    public Product() {
    }

    public Product(Long id, String productname, Long price, Client client) {
        this.id = id;
        this.productname = productname;
        this.price = price;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                ", client=" + client.getClientName() +
                '}';
    }
}
