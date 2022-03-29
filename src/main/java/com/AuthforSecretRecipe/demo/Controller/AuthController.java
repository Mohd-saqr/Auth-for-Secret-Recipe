package com.AuthforSecretRecipe.demo.Controller;

import com.AuthforSecretRecipe.demo.Modul.Person;
import com.AuthforSecretRecipe.demo.Modul.Posts;
import com.AuthforSecretRecipe.demo.Service.AuthoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {
    @Autowired
    private AuthoServices authoServices;

    @GetMapping("/")
    String HomePage(Model model, HttpServletRequest request) {
        authoServices.createAdmin();
        if (request.isRequestedSessionIdValid()) {
            if (authoServices.HomePage(model, request) == "user") {
                return "userPage";
            } else {
                return "adminPage";
            }
        }
        return "HomePage";
    }

    @PostMapping("/logOut")
    RedirectView logOut(HttpServletRequest request) {
        authoServices.logOut(request);

        return new RedirectView("/");
    }

    @GetMapping("/LoginPage")
    String LoginPage() {
        return "loginPage";
    }

    @GetMapping("/SignPage")
    String SignUpPage() {

        return "signUpPage";
    }

    @GetMapping("/userPage")
    String userPage() {
        return "userPage";
    }

    @GetMapping("/posts")
    String postPage(Model model) {
        authoServices.getPosts(model);
        return "posts";
    }

    @PostMapping("/Login")
    String Login(String username, String password, Model model, HttpServletRequest request) {
        if (authoServices.LoginUser(username, password, model, request) == "admin") {
            return "adminPage";
        } else if (authoServices.LoginUser(username, password, model, request) == "user") {
            return "userPage";
        }
        return "LoginPage";
    }

    @PostMapping("/Sign")
    String Sign(String username, String password, Model model) {
        if (authoServices.SignUpUser(username, password, model)) return "loginPage";
        return "signUpPage";
    }

    @PostMapping("/admin")
    String adminPage(Person user, Model model) {
        if (authoServices.LoginAdmin(user, model)) return "adminPage";
        return "loginPage";

    }

    @PostMapping("/AddPosts")
    String addPosts(@ModelAttribute Posts posts, Model model) {
        System.out.println(posts);
        authoServices.AddPost(posts.getContent(), posts.getId(), model);
        return "userPage";
    }

    @GetMapping("/AddPosts")
    String getPosts() {
        return "userPage";
    }

    @GetMapping("/deletePost/{id}")
    RedirectView deletePost(@PathVariable Long id, HttpServletRequest request) {
        authoServices.deletePost(id, request);
        return new RedirectView("/");
    }

    @ResponseBody
    @PostMapping("/addUserP")
    Person adduserP(@RequestBody Person person){
         authoServices.addUser(person);
         return person;
    }

    @ResponseBody
    @PostMapping("/addPostForUser/{userid}/{postid}")
    Person addPostForUser(@PathVariable Long userid ,@PathVariable Long postid){
        return authoServices.addPostsForUser(userid,postid);
    }

    @ResponseBody
    @PostMapping("/addPostp")
    Posts addPostP(@RequestBody Posts posts){
       return authoServices.addPostsP(posts);
    }


}
