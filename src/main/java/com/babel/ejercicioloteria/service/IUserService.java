package com.babel.ejercicioloteria.service;

import com.babel.ejercicioloteria.model.Bet;
import com.babel.ejercicioloteria.model.User;
import com.babel.ejercicioloteria.model.UserDTO;

import java.util.List;
import java.util.Map;

public interface IUserService {

    Map<String, UserDTO> getUsers();
    void addUser(User user);

    User getUser(String id);

    boolean addBet(List<Integer> list, String id);


}
