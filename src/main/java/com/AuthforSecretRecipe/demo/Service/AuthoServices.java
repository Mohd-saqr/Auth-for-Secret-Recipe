package com.AuthforSecretRecipe.demo.Service;

import com.AuthforSecretRecipe.demo.Modul.Person;
import com.AuthforSecretRecipe.demo.Modul.Posts;
import com.AuthforSecretRecipe.demo.Repo.PostsRepo;
import com.AuthforSecretRecipe.demo.Repo.personRepo;
import org.apache.catalina.session.StandardSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class AuthoServices implements Services {
    @Autowired
    private personRepo userRepo;
    @Autowired
    private PostsRepo postsRepo;
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
    public String HomePage(Model model ,HttpServletRequest request) {
        Person user = (Person) request.getSession().getAttribute("UserLog");
        Person admin = (Person) request.getSession().getAttribute("admin");
        if (user!=null){
            model.addAttribute("UserLog",userRepo.getById(user.getId()));
            model.addAttribute("allUser",userRepo.findAll());
            return "user";
        }else {
            model.addAttribute("admin",userRepo.getById(admin.getId()));
            model.addAttribute("allUser",userRepo.findAll());
            return "admin";
        }




    }

    @Override
    public String LoginUser(String username, String password, Model model, HttpServletRequest request) {
        Person person = userRepo.findByUserName(username);
        if (person==null) return "null";
        if (person.getUserName().equals("admin")){
            model.addAttribute("allUser",userRepo.findAll());
            model.addAttribute("admin",person);
            HttpSession session = request.getSession();
            session.setAttribute("allUser",userRepo.findAll());
            session.setAttribute("admin",person);
            return "admin";
        }
        if (person!=null && BCrypt.checkpw(password,person.getPassword())){
            model.addAttribute("UserLog",person);
            HttpSession session = request.getSession();
            session.setAttribute("UserLog",person);
            return "user";
        }

        return "null";
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

        model.addAttribute("err","username is exsist");
        return false;
    }

    @Override
    public void AdminPage() {

    }

    @Override
    public void userPage() {

    }

    @Override
    @Transactional
    public void AddPost(String content, Long id,Model model) {
     Optional<Person> person= userRepo.findById(id);
        Posts post = new Posts(content);
     person.get().getPosts().add(post);
     person.get().setPosts(person.get().getPosts());
     model.addAttribute("UserLog",userRepo.getById(id));

    }

    @Override
    public void deletePost(Long id ,HttpServletRequest request) {
        postsRepo.deleteById(id);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void logOut( HttpServletRequest request) {
        HttpSession request1 =request.getSession();
        request1.invalidate();
    }

    @Override
    public void getPosts(Model model) {
        model.addAttribute("allUsers",userRepo.findAll());

    }

    @Override
    public void createAdmin() {
       Person admin= userRepo.findByUserName("admin");
       if (admin==null){
           String password = BCrypt.hashpw("admin",BCrypt.gensalt(10));
           Person adminNew = new Person("admin",password);
           userRepo.save(adminNew);
       }
    }
    @Transactional
    public Person addPostsForUser(Long userId , Long postId) {
        Person person= userRepo.getById(userId);
        Posts post = postsRepo.getById(postId);
        person.getPosts().add(post);
        person.setPosts(person.getPosts());

        return person;
    }

    public Posts addPostsP(Posts posts) {
        postsRepo.save(posts);
        return   posts;
    }
}
