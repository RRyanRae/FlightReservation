package com.alpha.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
