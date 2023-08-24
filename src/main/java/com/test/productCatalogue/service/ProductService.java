package com.test.productCatalogue.service;

import com.test.productCatalogue.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ProductDTO getProductsBySku(String sku);

    int getAvailableProductsBySeller(Long sellerId);

    Map<String, List<ProductDTO>> groupProductsByBrand();

    Map<Double, List<ProductDTO>> groupProductsByPrice();

    Map<String, List<ProductDTO>> groupProductsByColor();

    Map<String, List<ProductDTO>> groupProductsBySize();

    void refreshProductData();
}
