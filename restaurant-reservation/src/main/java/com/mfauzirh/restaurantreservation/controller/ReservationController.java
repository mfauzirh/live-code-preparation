package com.mfauzirh.restaurantreservation.controller;

import com.mfauzirh.restaurantreservation.dto.AvailabilityResponseDTO;
import com.mfauzirh.restaurantreservation.dto.ReservationRequestDTO;
import com.mfauzirh.restaurantreservation.dto.ReservationResponseDTO;
import com.mfauzirh.restaurantreservation.entity.Reservation;
import com.mfauzirh.restaurantreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO request) {
        Reservation reservation = reservationService.createReservation(request.getName(), request.getReservationDate());

        ReservationResponseDTO response = new ReservationResponseDTO();
        response.setId(reservation.getId());
        response.setName(reservation.getName());
        response.setReservationDate(reservation.getReservationDate());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> getReservationsForWeek(@RequestParam String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        List<Reservation> reservations = reservationService.getReservationsForWeek(start);

        List<ReservationResponseDTO> response = reservations.stream()
                .map(r -> {
                    ReservationResponseDTO dto = new ReservationResponseDTO();
                    dto.setId(r.getId());
                    dto.setName(r.getName());
                    dto.setReservationDate(r.getReservationDate());
                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/availability")
    public ResponseEntity<AvailabilityResponseDTO> checkAvailability(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        boolean available = reservationService.checkAvailability(localDate);

        AvailabilityResponseDTO response = new AvailabilityResponseDTO();
        response.setAvailable(available);

        return ResponseEntity.ok(response);
    }
}
