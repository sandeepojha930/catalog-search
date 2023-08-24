package com.test.productCatalogue.service.impl;

import com.test.productCatalogue.dto.ProductDTO;
import com.test.productCatalogue.model.Product;
import com.test.productCatalogue.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void getProductsBySku() {
        // Setup
        Product mockProduct = new Product();
        mockProduct.setName("Test Product");
        mockProduct.setSku("XYZ");
        when(productRepository.findBySku(Mockito.any())).thenReturn(mockProduct);

        // Test
        ProductDTO result = productService.getProductsBySku("XYZ");

        // Verify
        assertEquals("Test Product", result.getName());
    }
}