package com.portfolio.personalPortfolio.controller;


import com.portfolio.personalPortfolio.business.concretes.UserManager;
import com.portfolio.personalPortfolio.entities.Userr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/getall")
    public List<Userr> getAllUsers(){
        return userManager.getAll();
    }

    @GetMapping("/{id}")
    public Userr getUserById(@PathVariable int id ){
        return userManager.getById(id);
    }

    @PostMapping("/add")
    public Userr add(@RequestBody Userr user){
        return userManager.add(user);
    }

    @PutMapping("{id}")
    public Userr update(@PathVariable int id, @RequestBody Userr user){
        user.setId(id);
        return userManager.update(user);

    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id){
        userManager.delete(id);
    }

}
