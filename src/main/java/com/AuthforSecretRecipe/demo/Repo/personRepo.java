package com.AuthforSecretRecipe.demo.Repo;

import com.AuthforSecretRecipe.demo.Modul.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepo extends JpaRepository<Person, Long> {
    Person findByUserName(String username);
}
