package com.lambdaschool.zoo;

import com.lambdaschool.zoo.models.Role;
import com.lambdaschool.zoo.models.User;
import com.lambdaschool.zoo.models.UserRoles;
import com.lambdaschool.zoo.repos.RoleRepository;
import com.lambdaschool.zoo.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("zoodata");
        Role r3 = new Role ("animaldata");
        Role r4 = new Role ("mgr");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
//        admins.add(new UserRoles(new User(), r2));
//        admins.add(new UserRoles(new User(), r3));
//        admins.add(new UserRoles(new User(), r4));

        ArrayList<UserRoles> zoodata = new ArrayList<>();
        zoodata.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> animaldatas = new ArrayList<>();
        animaldatas.add(new UserRoles(new User(), r3));

        ArrayList<UserRoles> mgr = new ArrayList<>();
        mgr.add(new UserRoles(new User(), r4));

        rolerepos.save(r1);
        rolerepos.save(r2);
        rolerepos.save(r3);
        rolerepos.save(r4);

        User u1 = new User("admin", "password", admins);
        User u2 = new User("zoodata", "zoopass", zoodata);
        User u3 = new User("animaldata", "animalpass", animaldatas);
        User u4 = new User("mgrperson", "managerpass", mgr);

        userrepos.save(u1);
        userrepos.save(u2);
        userrepos.save(u3);
        userrepos.save(u4);
    }
}
