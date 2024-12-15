package com.umarket.product_service.category_of_published_products.businesslogic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id //PRINCIPAL KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies that the id value is generated automatically.
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING) //Store the value of the status enumeration in a text string in the DB
    @Column(name = "status", nullable = false)
    private ProductStatus status = ProductStatus.AVAILABLE; //Initializes the state to Available by default

    @Column(name = "posted_at", updatable = false)
    private LocalDateTime postedAt;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY) //We define the many-to-one relationship, where many products can be related to a single category
    @JoinColumn(name = "category_id")
    private Category category;

    //@JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ProductImage> images;

    //CONSTRUCTORS
    public Product() {
        this.postedAt = LocalDateTime.now(); //This attribute needs  an automatic value at the time of object creation
    }

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.status = ProductStatus.AVAILABLE; //Default value
        this.postedAt = LocalDateTime.now(); //Default value
    }

    //ENUM FOR PRODUCT STATUS
    public enum ProductStatus {
        AVAILABLE,
        SOLD
    }
}
