package com.lambdaschool.zoo.repos;

import com.lambdaschool.zoo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
