package com.umarket.product_service.category_of_published_products.dataaccess;

import com.umarket.product_service.category_of_published_products.businesslogic.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  CategoryRepository extends JpaRepository<Category, Integer> {
}
