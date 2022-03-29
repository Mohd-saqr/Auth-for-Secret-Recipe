package com.AuthforSecretRecipe.demo.Repo;

import com.AuthforSecretRecipe.demo.Modul.Person;
import com.AuthforSecretRecipe.demo.Modul.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepo extends JpaRepository<Posts,Long> {


}
