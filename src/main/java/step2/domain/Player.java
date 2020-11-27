package step2.domain;

import step2.exception.NameLengthException;

import java.util.Objects;

public class Player {

    private final String name;

    private Player(final String name) {
        this.name = name;
    }
    public static Player of(final String name){
        validationName(name);
        return Player.of(name);
    }
    private static void validationName(final String name) {
        if (name.length() > 5) {
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
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
