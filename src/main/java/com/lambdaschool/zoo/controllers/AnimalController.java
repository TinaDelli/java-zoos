package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.AnimalService;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
public class AnimalController
{
    @Autowired
    private AnimalService animalService;


    @GetMapping(value = "/animals/count", produces = {"application/json"})
    public ResponseEntity<?> getCountZoosInAnimals()
    {
        return new ResponseEntity<>(animalService.getCountZoosInAnimals(), HttpStatus.OK);
    }


    @GetMapping(value = "/animals",
                produces = {"application/json"})
    public ResponseEntity<?> listAllAnimals()
    {
        return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
    }

}
