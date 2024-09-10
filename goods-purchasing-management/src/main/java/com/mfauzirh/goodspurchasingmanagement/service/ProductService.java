package com.mfauzirh.goodspurchasingmanagement.service;

import com.mfauzirh.goodspurchasingmanagement.entity.Product;
import com.mfauzirh.goodspurchasingmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> calculateOptimalPurchase(int budget) {
        List<Product> items = productRepository.findAll();
        List<Product> bestCombination = new ArrayList<>();
        int closestSum = 0;

        for (int i = 0; i < (1 << items.size()); i++) {
            List<Product> combination = new ArrayList<>();
            int sum = 0;

            for (int j = 0; j < items.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    combination.add(items.get(j));
                    sum += items.get(j).getPrice();
                }
            }

            if (sum <= budget && sum > closestSum) {
                closestSum = sum;
                bestCombination = combination;
            }
        }

        return bestCombination;
    }
}