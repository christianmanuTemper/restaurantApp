package com.example.restuarant.service;

import com.example.restuarant.entity.Request;
import com.example.restuarant.exceptions.NullException;
import com.example.restuarant.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests(){
        return requestRepository.findAllRequests();
    }

    public Request saveNewRequest(Request request){

        if(request.getDateRequested() == null){
            request.setDateRequested(setTimeStamp());
        }

        if(request.getFirstName() == null || request.getLastName() == null){
            throw new NullException("Request id: " + request.getRequestId() + " is missing a name please make sure both the first and last name is added.");
        }

        if(request.getEmail() == null){
            throw new NullException("Request id: " + request.getRequestId() + " is missing an email address please add a valid email address and try again.");
        }
        return requestRepository.save(request);
    }


    /* In App Methods */

    public Timestamp setTimeStamp(){
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        return newTimestamp;
    }

}
