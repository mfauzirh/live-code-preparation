package com.mfauzirh.farmapp.repository;

import com.mfauzirh.farmapp.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
