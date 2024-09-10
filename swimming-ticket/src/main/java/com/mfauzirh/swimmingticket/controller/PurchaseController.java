package com.mfauzirh.swimmingticket.controller;

import com.mfauzirh.swimmingticket.dto.PurchaseRequest;
import com.mfauzirh.swimmingticket.entity.Purchase;
import com.mfauzirh.swimmingticket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchase(@PathVariable Long id) {
        Purchase purchase = purchaseService.getPurchase(id);

        return ResponseEntity.ok(purchase);
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody PurchaseRequest request) {
        return ResponseEntity.ok(purchaseService.createPurchase(request));
    }
}
