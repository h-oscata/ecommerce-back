package com.umarket.product_service.category_of_published_products.businesslogic.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor //Lombok genera un constructor sin argumentos
@AllArgsConstructor //Lombok genera un constructor que toma todos los campos de la clase
public class Category {

    @Id //PRINCIPAL KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Specifies that the id value is generated automatically, using an identity strategy that allows the database to handle the generation of IDs.
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    // Relation with product
    @JsonIgnore //This is to prevent lazy loading (don't need a hibernate session)
    @OneToMany(mappedBy = "category") //It has a relationship from one to many products (a category can contain many products)
    private List<Product> products;
}
