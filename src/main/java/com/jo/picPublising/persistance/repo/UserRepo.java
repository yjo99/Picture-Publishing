package com.jo.picPublising.persistance.repo;

import com.jo.picPublising.persistance.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

        Optional<User> findUserByEmail(String email);

        Boolean existsUserByEmail(String email);

}
