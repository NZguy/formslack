package com.duncanandrew.formslack.repositories;

import org.springframework.data.repository.CrudRepository;
import com.duncanandrew.formslack.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {}
