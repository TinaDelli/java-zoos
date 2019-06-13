package com.lambdaschool.zoo.services;

import com.lambdaschool.zoo.models.Telephone;
import com.lambdaschool.zoo.models.Zoo;
import com.lambdaschool.zoo.repos.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zoorepos;

    @Override
    public ArrayList<Zoo> findAll()
    {
        ArrayList<Zoo> list= new ArrayList<>();
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Zoo updateZoo(Zoo zoo, long id)
    {
        Zoo currentZoo = zoorepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));

        if(zoo.getZooname() != null)
        {
            currentZoo.setZooname(zoo.getZooname());
        }

        if(zoo.getTelephones() != null)
        {
            currentZoo.setTelephones(zoo.getTelephones());
        }

        return zoorepos.save(currentZoo);
    }

    @Override
    public Zoo saveZoo(Zoo zoo)
    {
        Zoo newZoo = new Zoo();
        newZoo.setZooname(zoo.getZooname());

        for (Telephone t: zoo.getTelephones())
        {
            newZoo.getTelephones().add(new Telephone(t.getPhonetype(), t.getPhonenumber()));
        }
        return zoorepos.save(newZoo);
    }

    @Override
    public void deleteZoo(long id)
    {
        if(zoorepos.findById(id).isPresent())
        {
            zoorepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

}
