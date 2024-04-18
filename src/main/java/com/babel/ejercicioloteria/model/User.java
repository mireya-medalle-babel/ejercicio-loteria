package com.babel.ejercicioloteria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    private String id;
    private String name;

    private List<Bet> bets;

    public User(){
        bets = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(Bet bet) {
        this.bets.add(bet);
    }
}
