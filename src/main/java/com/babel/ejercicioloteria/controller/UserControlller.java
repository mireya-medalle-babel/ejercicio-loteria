package com.babel.ejercicioloteria.controller;

import com.babel.ejercicioloteria.model.Bet;
import com.babel.ejercicioloteria.model.User;
import com.babel.ejercicioloteria.model.UserDTO;
import com.babel.ejercicioloteria.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/loteria")
public class UserControlller {


    private final IUserService userService;

    public UserControlller(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<UserDTO> getUsers(){
        return new ArrayList<>(userService.getUsers().values());
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PutMapping(value = "/users/{id}")
    public void altaUsuario(@PathVariable String id, @RequestBody User user){
        user.setId(id);
        user.setName(user.getName());
        userService.addUser(user);
    }

    @PostMapping(value= "/users/{id}/bets")
    public boolean addUserBets(@PathVariable String id, @RequestBody ArrayList<Integer> bets) {
        return userService.addBet(bets, id);
    }


}
