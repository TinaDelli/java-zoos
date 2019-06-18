package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.views.CountZoosInAnimals;

import java.util.ArrayList;

public interface AnimalService
{
    ArrayList<Animal> findAll();

    void  delete(long id);

    ArrayList<CountZoosInAnimals> getCountZoosInAnimals();
}
