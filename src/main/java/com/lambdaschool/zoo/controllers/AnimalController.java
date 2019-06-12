package com.lambdaschool.zoo.controllers;

import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.services.AnimalService;
import com.lambdaschool.zoo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AnimalController
{
    @Autowired
    private AnimalService animalService;

    @Autowired
    private ZooService zooService;

    @GetMapping(value = "/animals/count", produces = {"application/json"})
    public ResponseEntity<?> getCountZoosInAnimals()
    {
        return new ResponseEntity<>(animalService.getCountZoosInAnimals(), HttpStatus.OK);
    }

    @GetMapping(value = "/zoos/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        ArrayList<Zoo> zooList = zooService.findAll();
        return new ResponseEntity<>(zooList, HttpStatus.OK);
    }

    @PutMapping(value = "/admin/zoos/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateZooById(
            @RequestBody
            Zoo updateZoo,
            @PathVariable
            long id)
    {
        zooService.updateZoo(updateZoo, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
