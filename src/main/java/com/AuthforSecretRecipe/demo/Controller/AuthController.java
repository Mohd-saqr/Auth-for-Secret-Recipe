package com.AuthforSecretRecipe.demo.Controller;

import com.AuthforSecretRecipe.demo.Modul.Person;
import com.AuthforSecretRecipe.demo.Service.AuthoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthController {
    @Autowired
    private AuthoServices authoServices;

    @GetMapping("/")
    String HomePage(Model model) {
        return "HomePage";
    }
    @GetMapping("/LoginPage")
    String LoginPage(){
        return "loginPage";
    }
    @GetMapping("/SignPage")
    String SignUpPage(){

        return "signUpPage";
    }

    @PostMapping("/Login")
    RedirectView Login(String username, String password, Model model) {
        if (authoServices.LoginUser(username,  password,model))return new RedirectView("SignPage");
        return new RedirectView("/");
    }

    @PostMapping("/Sign")
    RedirectView Sign(String username, String password,Model model) {
        if (authoServices.SignUpUser(username,password,model))return new RedirectView("LoginPage");
       return new RedirectView("SignPage");
    }

    @PostMapping("/admin")
    String adminPage(Person user ,Model model){
        if (authoServices.LoginAdmin(user,model)) return "adminPage";
        return "loginPage";

    }

}
