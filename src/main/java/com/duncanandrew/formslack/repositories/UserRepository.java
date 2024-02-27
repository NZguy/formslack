package com.duncanandrew.formslack.repositories;

import org.springframework.data.repository.CrudRepository;
import com.duncanandrew.formslack.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {}
