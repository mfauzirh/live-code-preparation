package com.mfauzirh.farmapp.controller;

import com.mfauzirh.farmapp.dto.ChickenDTO;
import com.mfauzirh.farmapp.entity.Chicken;
import com.mfauzirh.farmapp.service.ChickenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chickens")
@RequiredArgsConstructor
public class ChickenController {

    private final ChickenService chickenService;

    @PostMapping
    public ResponseEntity<Chicken> createChicken(@RequestBody ChickenDTO chickenDTO) {
        return ResponseEntity.ok(chickenService.createChicken(chickenDTO));
    }

    @GetMapping
    public ResponseEntity<List<ChickenDTO>> getAllChickens() {
        return ResponseEntity.ok(chickenService.findAllChickens());
    }
}
