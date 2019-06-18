package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.Telephone;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TelephoneRepository extends CrudRepository<Telephone, Long>
{
 ArrayList<Telephone>findTelephonesByPhoneidEquals(String phonenumber);
}
