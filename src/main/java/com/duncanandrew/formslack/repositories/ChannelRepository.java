package com.duncanandrew.formslack.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import com.duncanandrew.formslack.entities.Channel;
import com.duncanandrew.formslack.entities.ForumThread;

public interface ChannelRepository extends CrudRepository<Channel, Integer> {
    // TODO: Figure out getting channel/thread at once, there should be a way to do this in JPA
    Set<ForumThread> getThreadById(Integer threadId);
}
