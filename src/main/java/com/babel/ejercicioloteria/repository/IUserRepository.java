package com.babel.ejercicioloteria.repository;

import com.babel.ejercicioloteria.model.User;
import com.babel.ejercicioloteria.model.Bet;

import java.util.HashSet;
import java.util.Map;

public interface IUserRepository {

    Map<String,User> getUsers();
    void addUser(User user);

    User getUser(String id);

    boolean addBet(Bet bets, String id);
}
