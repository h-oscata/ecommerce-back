package com.umarket.product_service.category_of_published_products.dataaccess;

import com.umarket.product_service.category_of_published_products.businesslogic.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
