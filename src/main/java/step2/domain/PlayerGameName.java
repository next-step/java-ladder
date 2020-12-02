package step2.domain;

import step2.exception.NameLengthException;

import java.util.Objects;

public class PlayerGameName {
    public static final int PLAYER_NAME_MIN_LENGTH = 5;

    private final String name;

    private PlayerGameName(String name) {
        validationName(name);
        this.name = name;
    }

    public static PlayerGameName of(String name) {
        return new PlayerGameName(name);
    }

    private static void validationName(final String name) {
        if (name.length() > PLAYER_NAME_MIN_LENGTH) {
            throw new NameLengthException();
        }
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerGameName that = (PlayerGameName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
