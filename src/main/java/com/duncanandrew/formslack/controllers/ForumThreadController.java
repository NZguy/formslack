package com.duncanandrew.formslack.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.duncanandrew.formslack.entities.Channel;
import com.duncanandrew.formslack.entities.ForumThread;
import com.duncanandrew.formslack.repositories.ChannelRepository;
import com.duncanandrew.formslack.repositories.ForumThreadRepository;

public class ForumThreadController {
    
    private final ForumThreadRepository forumThreadRepository;
    private final ChannelRepository channelRepository;

    public ForumThreadController(ForumThreadRepository forumThreadRepository, ChannelRepository channelRepository){
        this.forumThreadRepository = forumThreadRepository;
        this.channelRepository = channelRepository;
    }

    @GetMapping("channel/{channelId}/threads")
    public Iterable<ForumThread> findAllThreads(@PathVariable("channelId") Integer channelId){
        Optional<Channel> optChannel = channelRepository.findById(channelId);
        if(!optChannel.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        return optChannel.get().getThreads();
    }

    @PostMapping("channel/{channelId}/threads")
    public ForumThread addThread(@PathVariable("channelId") Integer channelId, @RequestBody ForumThread thread){
        Optional<Channel> optChannel = channelRepository.findById(channelId);
        if(!optChannel.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        ForumThread newThread = new ForumThread(thread.getTitle(), optChannel.get());
        return this.forumThreadRepository.save(newThread);
    }



}
