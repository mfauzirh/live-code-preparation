package com.mfauzirh.restaurantreservation.repository;

import com.mfauzirh.restaurantreservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    int countByReservationDate(LocalDate date);

    List<Reservation> findAllByReservationDateBetween(LocalDate startDate, LocalDate endDate);
}