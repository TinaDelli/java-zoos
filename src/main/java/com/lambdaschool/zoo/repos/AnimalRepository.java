package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.views.CountZoosInAnimals;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    // SELECT z.animalid, a.animaltype, count(z.zooid) as countzoos
    //FROM zooanimals z
    //INNER JOIN  animal a
    // on z.animalid = a.animalid
    //GROUP BY z.animalid, a.animaltype

    @Query(value = "SELECT z.animalid, a.animaltype, count(z.zooid) as countzoos FROM zooanimals z INNER JOIN  animal a on z.animalid = a.animalid GROUP BY z.animalid, a.animaltype", nativeQuery = true)
    ArrayList<CountZoosInAnimals> getCountZoosInAnimals();

    @Modifying
    @Query(value = "DELETE FROM zooanimals where animalid = :animalid", nativeQuery = true)
    void deleteZoosFromZooanimals(long animalid);

}
