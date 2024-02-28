package com.duncanandrew.formslack.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "threads")
public class ForumThread {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thread_id")
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;

    @OneToMany(mappedBy = "thread")
    Set<Message> messages;

    private ForumThread() {}
    
    public ForumThread(String title, Channel channel){
        this.title = title;
        this.channel = channel;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public Set<Message> getMessages(){
        return this.messages;
    }

}
