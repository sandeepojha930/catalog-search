package com.test.productCatalogue.repository;

import com.test.productCatalogue.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findBySku(String sku);

    List<Product> findBySellerId(Long sellerId);
}
