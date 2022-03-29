package com.AuthforSecretRecipe.demo.Service;

import com.AuthforSecretRecipe.demo.Modul.Person;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Services {
   List<Person> getAllUsers();
   Person getUser (Person user);
   void addUser (Person user);
   String HomePage(Model model ,HttpServletRequest request);
   String LoginUser(String username, String password, Model model, HttpServletRequest request);
   boolean LoginAdmin(Person user, Model model);
   boolean SignUpUser(String username, String password ,Model model);
   void AdminPage();
   void userPage();
   void AddPost(String content,Long id,Model model);
   void deletePost(Long id,HttpServletRequest request);
   void deleteUser(Long id);
   void logOut( HttpServletRequest request);

   void getPosts(Model model);

    void createAdmin();
}
