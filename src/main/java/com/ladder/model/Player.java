package com.ladder.model;

import com.ladder.exception.PlayerNameLengthException;
import com.ladder.utils.AssertUtils;

import java.util.Objects;

public class Player {

    public static final int LENGTH_OF_USER_NAME = 5;
    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player of(final String name) {
        AssertUtils.checkNull(name);
        if (name.length() > LENGTH_OF_USER_NAME) {
            throw new PlayerNameLengthException(name);
        }
        return new Player(name);
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
