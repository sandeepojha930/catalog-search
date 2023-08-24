package com.test.productCatalogue.service.impl;

import com.test.productCatalogue.dto.ProductDTO;
import com.test.productCatalogue.exception.ProductNotFoundException;
import com.test.productCatalogue.model.Product;
import com.test.productCatalogue.repository.ProductRepository;
import com.test.productCatalogue.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    CacheManager cacheManager;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#sku")
    public ProductDTO getProductsBySku(String sku) {
        logger.info("Going to fetch product from database");
        Product product = productRepository.findBySku(sku);
        if (product == null) {
            throw new ProductNotFoundException("No product found for given SKU: " + sku);
        }
        return mapToDto(product);
    }

    public int getAvailableProductsBySeller(Long sellerId) {

        return productRepository.findBySellerId(sellerId).size();
    }

    public Map<String, List<ProductDTO>> groupProductsByBrand() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToDto).collect(Collectors.groupingBy(ProductDTO::getBrand));
    }

    public Map<Double, List<ProductDTO>> groupProductsByPrice() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToDto).collect(Collectors.groupingBy(ProductDTO::getPrice));
    }

    public Map<String, List<ProductDTO>> groupProductsByColor() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToDto).collect(Collectors.groupingBy(ProductDTO::getColor));
    }

    public Map<String, List<ProductDTO>> groupProductsBySize() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToDto).collect(Collectors.groupingBy(ProductDTO::getSize));
    }

    @Override
    public void refreshProductData() {
       Cache cache= cacheManager.getCache("products");
       if(cache != null)
           cache.clear();
    }

    private ProductDTO mapToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrand(product.getBrand());
        productDTO.setCategory(product.getCategory());
        productDTO.setName(product.getName());
        productDTO.setColor(product.getColor());
        productDTO.setPrice(product.getPrice());
        productDTO.setSize(product.getSize());
        productDTO.setSku(product.getSku());
        productDTO.setAvlQty(product.getAvlQty());
        return productDTO;
    }
}
