package com.mfauzirh.farmapp.service;

import com.mfauzirh.farmapp.entity.Income;
import com.mfauzirh.farmapp.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;

    private static final Long DEFAULT_INCOME_ID = 1L; // Default ID for single record

    public Income getIncome() {
        return incomeRepository.findById(DEFAULT_INCOME_ID)
                .orElseThrow(() -> new RuntimeException("Income record not found"));
    }
}
