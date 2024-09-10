package com.mfauzirh.goodspurchasingmanagement.controller;


import com.mfauzirh.goodspurchasingmanagement.entity.Product;
import com.mfauzirh.goodspurchasingmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/optimal")
    public ResponseEntity<List<Product>> calculateOptimalPurchase(@RequestParam int budget) {
        return ResponseEntity.ok(productService.calculateOptimalPurchase(budget));
    }
}
