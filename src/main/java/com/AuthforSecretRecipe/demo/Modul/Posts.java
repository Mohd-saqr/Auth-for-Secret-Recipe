package com.AuthforSecretRecipe.demo.Modul;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@JsonIgnoreProperties({"posts"})
public class Posts  {
    @Id
    @GeneratedValue()
    private Long id;
    private String content;

    public Posts(String content) {
        this.content = content;
    }

    public Posts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return
                "content='" + content + '\'' +
                '}';
    }
}
