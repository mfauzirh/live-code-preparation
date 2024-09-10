package com.mfauzirh.restaurantreservation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationResponseDTO {
    private Long id;
    private String name;
    private LocalDate reservationDate;
}