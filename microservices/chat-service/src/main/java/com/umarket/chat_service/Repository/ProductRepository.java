package com.umarket.chat_service.Repository;

import com.umarket.chat_service.model.UtilModal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT seller_id FROM product WHERE product_id = :idP", nativeQuery = true)
    Integer obtenerIdPorProducto(@Param("idP") int idP);
}