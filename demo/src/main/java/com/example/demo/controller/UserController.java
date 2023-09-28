package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.Response.BaseResponse;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    public String  findAll(Model model) {
        model.addAttribute("users",service.getAll());
        model.addAttribute("user",new User());

        return "index";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute User user){
        service.add(user);
        return "redirect:/api/user/all";
    }


    @GetMapping("/edit")
    public String editUse(@RequestParam Long id, Model model){
        Optional<User> user = service.getById(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user){
        service.add(user);
        return "redirect:/api/user/all";
    }

    @GetMapping("/del")
    public String del(@RequestParam Long id){
        service.del(id);
        return "redirect:/api/user/all";}
}
