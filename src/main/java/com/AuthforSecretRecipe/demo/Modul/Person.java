package com.AuthforSecretRecipe.demo.Modul;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"posts"})
public class Person implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;
    private String userName;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posts_id",referencedColumnName = "id")
   private List<Posts> posts = new ArrayList<>();

    public Person() {
    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }
}
