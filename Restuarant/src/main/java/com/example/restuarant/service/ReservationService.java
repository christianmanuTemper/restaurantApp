package com.example.restuarant.service;

import com.example.restuarant.entity.Reservation;
import com.example.restuarant.entity.User;
import com.example.restuarant.exceptions.NullException;
import com.example.restuarant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservation(){
        return this.reservationRepository.findAllReservations();
    }

    public Reservation saveNewReservation(Reservation reservation){
        if(reservation.getHostFirstName() == null || reservation.getHostLastName() == null){
            throw new NullException("This reservation is missing a host name, please add it and try again.");
        }

        if(reservation.getDateReserved() == null){
            reservation.setDateReserved(setTimeStamp());
        }

        if(reservation.getDate_requested() == null){
            reservation.setDate_requested(setTimeStamp());
        }

        if(reservation.getActive() == null){
            reservation.setActive(0);
        }

        if(reservation.getUserId() == null){
            throw new NullException("This reservation is missing a user Id, please add an Id and try again.");
        }
        return reservationRepository.save(reservation);
    }

    public Reservation deleteReservation(Integer reservationId){
      Reservation reservation = reservationRepository.deleteReservationByReservationId(reservationId);
      return reservation;
    }

    /* In app Methods */
    public Timestamp setTimeStamp(){
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        return newTimestamp;
    }

}
