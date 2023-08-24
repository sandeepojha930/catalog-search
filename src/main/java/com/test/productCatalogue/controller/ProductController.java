package com.test.productCatalogue.controller;

import com.test.productCatalogue.dto.ProductDTO;
import com.test.productCatalogue.helper.ApiResponse;
import com.test.productCatalogue.helper.ResponseHelper;
import com.test.productCatalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/group-by-brand", name = "Group by Brand/Client")
    public ResponseEntity<ApiResponse<Map<String, List<ProductDTO>>>> groupProductsByBrand() {
        return ResponseHelper.success(productService.groupProductsByBrand());
    }

    @GetMapping(value = "/group-by-price", name = "Group by Price")
    public ResponseEntity<ApiResponse<Map<Double, List<ProductDTO>>>> groupProductsByPrice() {
        return ResponseHelper.success(productService.groupProductsByPrice());
    }

    @GetMapping(value = "/group-by-color", name = "Group by Color")
    public ResponseEntity<ApiResponse<Map<String, List<ProductDTO>>>> groupProductsByColor() {
        return ResponseHelper.success(productService.groupProductsByColor());
    }

    @GetMapping(value = "/group-by-size", name = "Group by Size")
    public ResponseEntity<ApiResponse<Map<String, List<ProductDTO>>>> groupProductsBySize() {
        return ResponseHelper.success(productService.groupProductsBySize());
    }

    @GetMapping(value = "/by-sku/{sku}", name = "Get by SKU")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductsBySku(@PathVariable String sku) {
        return ResponseHelper.success(productService.getProductsBySku(sku));
    }

    @GetMapping(value = "available-products/{sellerId}", name = "Available number of products by seller")
    public ResponseEntity<ApiResponse<Integer>> getAvailableProductsBySeller(@PathVariable Long sellerId) {
        return ResponseHelper.success(productService.getAvailableProductsBySeller(sellerId));
    }

}
