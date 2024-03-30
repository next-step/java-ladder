package laddergame.domain;

import laddergame.exception.InvalidPlayerException;

import java.util.Objects;

import static laddergame.util.Validator.isValidStringLength;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!isValidStringLength(name, MAX_NAME_LENGTH)) {
            throw new InvalidPlayerException(name);
        }
    }

    public static Player valueOf(String name) {
        return new Player(name);
    }

    public int lengthOfName() {
        return name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String name() {
        return name;
    }
}
