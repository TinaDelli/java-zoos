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

@RestController
public class AdminController
{
    @Autowired
    private AnimalService animalService;

    @Autowired
    private ZooService zooService;

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

    @PostMapping(value = "/admin/zoos", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewZoo(@Valid
                                       @RequestBody Zoo newZoo)
    {
        newZoo = zooService.saveZoo(newZoo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newZoo.getZooid()).toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/admin/zoos/{id}")
    public ResponseEntity<?> deleteZooById(@PathVariable long id)
    {
        zooService.deleteZoo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
