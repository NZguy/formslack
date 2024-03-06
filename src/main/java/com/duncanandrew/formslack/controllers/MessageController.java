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
import com.duncanandrew.formslack.entities.Message;
import com.duncanandrew.formslack.entities.User;
import com.duncanandrew.formslack.repositories.ChannelRepository;
import com.duncanandrew.formslack.repositories.MessageRepository;
import com.duncanandrew.formslack.repositories.UserRepository;

public class MessageController {

    private final MessageRepository messageRepository;
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;

    public MessageController(MessageRepository messageRepository, ChannelRepository channelRepository, UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("channel/{channelId}/threads/{threadId}/messages")
    public Iterable<Message> findAllMessages(@PathVariable("channelId") Integer channelId, @PathVariable("threadId") Integer threadId){
        Optional<Channel> optChannel = channelRepository.findById(channelId);
        if(!optChannel.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        return optChannel.get().getThreadById(threadId).getMessages();
    }

    @PostMapping("channel/{channelId}/threads/{threadId}/messages")
    public Message addMessage(@PathVariable("channelId") Integer channelId, @PathVariable("threadId") Integer threadId, @RequestBody Message message){
        Optional<User> optUser = userRepository.findById(message.getUser().getId());
        Optional<Channel> optChannel = channelRepository.findById(channelId);
        if(!optChannel.isPresent() || !optUser.isPresent()){
            // Only in the controller, service layer should only return null and controller throws error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
        ForumThread thread = optChannel.get().getThreadById(threadId);
        User user = optUser.get();
        Message newMessage = new Message(message.getText(), thread, user);
        messageRepository.save(newMessage);
        return newMessage;
        // TODO: Convert to SQL query later
    }

}
