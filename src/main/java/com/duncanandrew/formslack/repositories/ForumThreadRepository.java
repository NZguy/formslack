package com.duncanandrew.formslack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duncanandrew.formslack.entities.ForumThread;

public interface ForumThreadRepository extends JpaRepository<ForumThread, Integer> {}
