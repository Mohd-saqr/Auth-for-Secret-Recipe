package com.AuthforSecretRecipe.demo.Service;

import com.AuthforSecretRecipe.demo.Modul.Person;
import com.AuthforSecretRecipe.demo.Repo.personRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AuthoServices implements Services {
    @Autowired
    private personRepo userRepo;
    @Override
    public List<Person> getAllUsers() {
        return null;
    }

    @Override
    public Person getUser(Person user) {
        return null;
    }

    @Override
    public void addUser(Person user) {
        String HashPass= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
       Person newPerson= new Person(user.getUserName(),HashPass);
       userRepo.save(newPerson);
    }

    @Override
    public void HomePage() {

    }

    @Override
    public boolean LoginUser(String username, String password, Model model) {
        Person person = userRepo.findByUserName(username);
        if (person!=null && BCrypt.checkpw(password,person.getPassword())){
            model.addAttribute(person);
            return true;
        }
        return false;
    }

    @Override
    public boolean LoginAdmin(Person user, Model model) {
return false;
    }


    @Override
    public boolean SignUpUser(String username, String password,Model model) {

        if (userRepo.findByUserName(username)==null) {
            String HashPass = BCrypt.hashpw(password, BCrypt.gensalt(10));
            Person newPerson = new Person(username, HashPass);
            userRepo.save(newPerson);
            return true;
        }

        model.addAttribute("error","username is exsist");
        return false;
    }

    @Override
    public void AdminPage() {

    }

    @Override
    public void userPage() {

    }
}
