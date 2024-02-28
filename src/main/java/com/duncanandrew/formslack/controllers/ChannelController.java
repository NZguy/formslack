package com.duncanandrew.formslack.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.duncanandrew.formslack.entities.Channel;
import com.duncanandrew.formslack.entities.User;
import com.duncanandrew.formslack.repositories.ChannelRepository;
import com.duncanandrew.formslack.repositories.UserRepository;

public class ChannelController {
    
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;

    public ChannelController(ChannelRepository channelRepository, UserRepository userRepository){
        this.channelRepository = channelRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/channels")
    public Iterable<Channel> findAllChannels(){
        return this.channelRepository.findAll();
    }

    @PostMapping("/channels")
    public Channel addChannel(@RequestBody Channel channel){
        return this.channelRepository.save(channel);
    }

    @GetMapping("/channels/{channelId}/users")
    public Iterable<User> findAllUsers(@PathVariable("channelId") Integer channelId){
        Optional<Channel> opt = this.channelRepository.findById(channelId);
        if(opt.isPresent()){
            return opt.get().getUsers();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PostMapping("channels/{channelId}/users/{userId}")
    public Channel addUser(@PathVariable("channelId") Integer channelId, @PathVariable("userId") Integer userId){
        Optional<Channel> channel = this.channelRepository.findById(channelId);
        if(channel.isPresent()){
            Optional<User> user = this.userRepository.findById(userId);
            if (user.isPresent()){
                Channel ret = channel.get().addUser(user.get());
                channelRepository.save(ret);
                return ret;
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
            }
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "channel not found");
        }
    }

}
