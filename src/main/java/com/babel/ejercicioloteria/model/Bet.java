package com.babel.ejercicioloteria.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bet {
    private Set<Integer> bets;

    public Bet(){
        bets = new HashSet<>();
    }


    public Set<Integer> getBets() {
        return bets;
    }

    public void setBets(Set<Integer> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return bets+"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return Objects.equals(bets, bet.bets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bets);
    }
}
