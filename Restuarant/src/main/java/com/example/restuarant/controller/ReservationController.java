package com.example.restuarant.controller;


import com.example.restuarant.entity.Reservation;
import com.example.restuarant.entity.User;
import com.example.restuarant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Reservation>> findAllReservations(){
        List<Reservation> reservations = reservationService.getAllReservation();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping(path = "/save/newUser")
    public ResponseEntity<Reservation> saveNewReservation(@RequestBody Reservation reservation){
        Reservation newReservation = reservationService.saveNewReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

}
