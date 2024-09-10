package com.mfauzirh.restaurantreservation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationRequestDTO {
    private String name;
    private LocalDate reservationDate;
}

