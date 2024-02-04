package com.spring.crud.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.crud.users.model.User;
import com.spring.crud.users.service.UserService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("users", user);
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String createUser(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/user-create";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String daleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updataUserForm(@PathVariable("id") Integer id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }
@PostMapping("/user-update")
    public String updateUser(@Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/user-update";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }
}
