package com.duncanandrew.formslack.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    ForumThread thread;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    private Message() {}

    public Message(String text, ForumThread thread, User user){
        this.text = text;
        this.thread = thread;
        this.user = user;
    }

    public Integer getId(){
        return this.id;
    }

    public String getText(){
        return this.text;
    }

    public User getUser(){
        return this.user;
    }

}
