package com.ladder.model;

import com.ladder.exception.NameLengthException;
import com.ladder.utils.AssertUtils;

import java.util.Objects;

public class Player {

    public static final int LENGTH_OF_USER_NAME = 5;

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    static Player of(String name) {
        AssertUtils.checkNull(name);
        if (name.length() > LENGTH_OF_USER_NAME) {
            throw new NameLengthException(name);
        }
        return new Player(name);
    }

    boolean isMatch(String playerName) {
        return this.name.equals(playerName);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
