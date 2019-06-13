package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Zoo;

import java.util.ArrayList;

public interface ZooService
{
    ArrayList<Zoo> findAll();

    Zoo updateZoo(Zoo zoo, long id);

    Zoo saveZoo(Zoo zoo);

    void deleteZoo(long id);
}
