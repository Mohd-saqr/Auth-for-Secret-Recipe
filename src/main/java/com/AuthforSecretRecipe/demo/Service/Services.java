package com.AuthforSecretRecipe.demo.Service;

import com.AuthforSecretRecipe.demo.Modul.Person;
import org.springframework.ui.Model;

import java.util.List;

public interface Services {
   List<Person> getAllUsers();
   Person getUser (Person user);
   void addUser (Person user);
   void HomePage();
   boolean LoginUser(String username, String password, Model model);
   boolean LoginAdmin(Person user, Model model);
   boolean SignUpUser(String username, String password ,Model model);
   void AdminPage();
   void userPage();
}
