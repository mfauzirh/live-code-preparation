package com.mfauzirh.farmapp.controller;

import com.mfauzirh.farmapp.entity.Income;
import com.mfauzirh.farmapp.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping
    public ResponseEntity<Income> getIncome() {
        return ResponseEntity.ok(incomeService.getIncome());
    }
}
