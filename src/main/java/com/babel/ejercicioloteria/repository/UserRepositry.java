package com.babel.ejercicioloteria.repository;

import com.babel.ejercicioloteria.model.Bet;
import com.babel.ejercicioloteria.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositry implements IUserRepository {
    private final Map<String, User> userRepository = new HashMap<>();

    @Override
    public Map<String,User> getUsers(){
        return userRepository;
    }
    @Override
    public void addUser(User user) {
        userRepository.put(user.getId(),user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.get(id);
    }

    public boolean addBet (Bet bets, String id) {
        User user = userRepository.get(id);
        if(user != null) {
            user.setBets(bets);
            return true;
        }
        return false;
    }



}
