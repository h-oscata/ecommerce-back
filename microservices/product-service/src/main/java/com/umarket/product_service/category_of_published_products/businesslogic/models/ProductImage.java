package com.umarket.product_service.category_of_published_products.businesslogic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_images")
@Getter
@Setter
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id") //PRINCIPAL KEY
    private Integer id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne //Many_to_one relationship. Which means that a product can have multiple images
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;
}
