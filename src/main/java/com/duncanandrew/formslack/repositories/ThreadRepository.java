package com.duncanandrew.formslack.repositories;

import org.springframework.data.repository.CrudRepository;
import com.duncanandrew.formslack.entities.ForumThread;

public interface ThreadRepository extends CrudRepository<ForumThread, Integer> {}
