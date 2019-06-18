package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Animal;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repos.AnimalRepository;
import com.lambdaschool.zoo.repos.ZooRepository;
import com.lambdaschool.zoo.views.CountZoosInAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    private AnimalRepository anirepos;

    @Override
    public ArrayList<Animal> findAll()
    {
        ArrayList<Animal> list = new ArrayList<>();
        anirepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        if(anirepos.findById(id).isPresent())
        {
            anirepos.deleteZoosFromZooanimals(id);
            anirepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public ArrayList<CountZoosInAnimals> getCountZoosInAnimals()
    {
        return anirepos.getCountZoosInAnimals();
    }
}
