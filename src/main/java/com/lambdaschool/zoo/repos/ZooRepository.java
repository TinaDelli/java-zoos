package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.Zoo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    ArrayList<Zoo> findZoosByZoonameEquals(String name);
}
