package com.duncanandrew.formslack.entities;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "channels")
public class Channel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "channel")
    Set<ForumThread> threads;

    @ManyToMany
    @JoinTable(
        name = "user_channel",
        joinColumns = @JoinColumn(name = "channel_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> users;

    private Channel() {}

    public Channel(String name){
        this.name = name;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Set<User> getUsers(){
        return this.users;
    }

    public Channel addUser(User user){
        this.users.add(user);
        return this;
    }

    public Set<ForumThread> getThreads(){
        return this.threads;
    }

    public ForumThread getThreadById(Integer threadId){
        for (ForumThread forumThread : threads) {
            if(forumThread.getId() == threadId){
                return forumThread;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }

}
