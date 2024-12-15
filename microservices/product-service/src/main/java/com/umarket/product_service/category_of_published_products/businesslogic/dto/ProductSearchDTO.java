package com.umarket.product_service.category_of_published_products.businesslogic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ProductSearchDTO {
    private Integer id;
    private String name;
}
