package com.test.productCatalogue.controller;

import com.test.productCatalogue.dto.ProductDTO;
import com.test.productCatalogue.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getProductsBySku() throws Exception {
        // Setup
        ProductDTO mockProduct = new ProductDTO();
        mockProduct.setName("Test Product");
        mockProduct.setSku("XYZ");
        when(productService.getProductsBySku(any())).thenReturn(mockProduct);

        // Test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products/by-sku/XYZ"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$['data'].name").value("Test Product"));
    }
}