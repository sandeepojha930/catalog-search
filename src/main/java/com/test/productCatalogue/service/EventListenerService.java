package com.test.productCatalogue.service;

import com.test.productCatalogue.event.BrandEvent;
import com.test.productCatalogue.event.SupplierEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventListenerService {

    @Autowired
    ProductService productService;

    @EventListener
    public void handleBrandEvent(BrandEvent brandEvent) {
        productService.refreshProductData();
    }

    @EventListener
    public void handleSupplierEvent(SupplierEvent supplierEvent) {
        productService.refreshProductData();
    }
}
