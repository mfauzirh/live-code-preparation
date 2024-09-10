package com.mfauzirh.farmapp.repository;

import com.mfauzirh.farmapp.entity.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChickenRepository extends JpaRepository<Chicken, Long> {
}