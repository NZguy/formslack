package com.duncanandrew.formslack.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "display_name")
    private String displayName;

    private String email;

    @OneToMany(mappedBy = "user")
    Set<Message> messages;

    @ManyToMany(mappedBy = "users")
    Set<Channel> channels;

    private User() {}

    public User(String displayName, String email){
        this.displayName = displayName;
        this.email = email;
    }

    public Integer getId(){
        return this.id;
    }

    public String getDisplayName(){
        return this.displayName;
    }

    public String getEmail(){
        return this.email;
    }
}