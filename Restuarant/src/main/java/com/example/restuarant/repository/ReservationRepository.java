package com.example.restuarant.repository;

import com.example.restuarant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT u FROM Reservation u")
    List<Reservation> findAllReservations();

    Reservation deleteReservationByReservationId(Integer reservationId);
}
