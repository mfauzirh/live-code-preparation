package com.mfauzirh.goodspurchasingmanagement.repository;

import com.mfauzirh.goodspurchasingmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
