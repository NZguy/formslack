package com.duncanandrew.formslack.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duncanandrew.formslack.entities.Channel;
import com.duncanandrew.formslack.entities.ForumThread;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    // TODO: Figure out getting channel/thread at once, there should be a way to do this in JPA
    // Use @Query 
    //Set<ForumThread> findByThreadId(Integer threadId);
}
