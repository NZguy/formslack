package com.duncanandrew.formslack.repositories;

import org.springframework.data.repository.CrudRepository;
import com.duncanandrew.formslack.entities.Channel;

public interface ChannelRepository extends CrudRepository<Channel, Integer> {}
