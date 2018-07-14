package com.deltax.movies.controller;

import com.deltax.movies.models.ActorRequest;
import com.deltax.movies.models.AllMoviesResponse;
import com.deltax.movies.models.ProducerRequest;
import com.deltax.movies.models.Response;
import com.deltax.movies.service.AddActor;
import com.deltax.movies.service.AddProducer;
import com.deltax.movies.service.GetAllMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MoviesController  {
    @Autowired
    private AddActor addActor;
    @Autowired
    private AddProducer addProducer;
    @Autowired
    private GetAllMovies getAllMovies;

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping(value = "/addActor",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<Response> createUser(@Valid @RequestBody ActorRequest actorRequest)throws Exception {
        //1.add actor
        addActor.addActor(actorRequest);

        //2. generate response
        Response response =new Response();
        response.setMessage("new actor added successfully");

        //3.send response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/addProducer",method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public ResponseEntity<Response> addProducer(@Valid @RequestBody ProducerRequest producerRequest)throws Exception {
        //1.add actor
        addProducer.addProducer(producerRequest);

        //2. generate response
        Response response =new Response();
        response.setMessage("new producer added successfully");

        //3.send response
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllMovies",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<AllMoviesResponse> getAllMovies() throws Exception {
        //1.fetch all movies
        AllMoviesResponse allMoviesResponse=getAllMovies.getAllMovies();

        //2.send response
        return new ResponseEntity<>(allMoviesResponse, HttpStatus.OK);

    }



}
