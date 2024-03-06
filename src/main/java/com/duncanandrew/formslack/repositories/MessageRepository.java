package com.duncanandrew.formslack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duncanandrew.formslack.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {}
