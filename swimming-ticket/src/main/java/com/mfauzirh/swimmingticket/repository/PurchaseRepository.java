package com.mfauzirh.swimmingticket.repository;

import com.mfauzirh.swimmingticket.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
