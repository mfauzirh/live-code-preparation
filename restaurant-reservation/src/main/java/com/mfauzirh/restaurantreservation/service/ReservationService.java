package com.mfauzirh.restaurantreservation.service;

import com.mfauzirh.restaurantreservation.entity.Reservation;
import com.mfauzirh.restaurantreservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation createReservation(String name, LocalDate reservationDate) {
        if (isHoliday(reservationDate)) {
            throw new IllegalArgumentException("Reservations are not allowed on Wednesdays and Fridays.");
        }

        if (reservationRepository.countByReservationDate(reservationDate) >= 2) {
            throw new IllegalStateException("The reservation limit for this date has been reached.");
        }

        Reservation reservation = new Reservation();
        reservation.setName(name);
        reservation.setReservationDate(reservationDate);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsForWeek(LocalDate startDate) {
        LocalDate endDate = startDate.plusDays(6);
        return reservationRepository.findAllByReservationDateBetween(startDate, endDate);
    }

    public boolean checkAvailability(LocalDate date) {
        if (isHoliday(date)) {
            return false;
        }
        return reservationRepository.countByReservationDate(date) < 2;
    }

    private boolean isHoliday(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.WEDNESDAY || dayOfWeek == DayOfWeek.FRIDAY;
    }
}
