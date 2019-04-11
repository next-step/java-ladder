package domain;

import java.util.Objects;

public class Player {
    private String name;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    public static final String ALL = "all";

    public Player(String name) {
        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean equals(String inputName) {
        return name.equals(inputName);
    }

}
