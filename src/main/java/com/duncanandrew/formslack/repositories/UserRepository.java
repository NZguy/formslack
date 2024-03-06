package com.duncanandrew.formslack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duncanandrew.formslack.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
