package com.example.restuarant.controller;

import com.example.restuarant.entity.Request;
import com.example.restuarant.entity.User;
import com.example.restuarant.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/requests")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService){
        this.requestService = requestService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Request>> findAllRequests(){
        List<Request> requests = requestService.getAllRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PostMapping(path = "/save/newRequest")
    public ResponseEntity<Request> addNewRequest(@RequestBody Request request){
        Request newRequest = requestService.saveNewRequest(request);
        return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
    }

}
