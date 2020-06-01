package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNameEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNameLengthException;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_VALUE_LENGTH = 5;

    private final String name;
    private final int location;

    public Player(String name, int location) {
        validate(name);
        this.name = name;
        this.location = location;
    }

    public int length() {
        return this.name.length();
    }

    public String getName() {
        return this.name;
    }

    public Player moveRight() {
        return new Player(this.name, this.location + 1);
    }

    public Player moveLeft() {
        return new Player(this.name, this.location - 1);
    }

    private void validate(String nameValue) {
        validateNull(nameValue);
        validateNameLength(nameValue);
        validateEmptyName(nameValue);
    }

    private void validateNull(String nameValue) {
        if (nameValue == null) {
            throw new PlayerNameEmptyException("Player's name must not be null");
        }
    }

    private void validateNameLength(String nameValue) {
        if (nameValue.length() > MAX_NAME_VALUE_LENGTH) {
            throw new PlayerNameLengthException("Player's name length muse be smaller than 5");
        }
    }

    private void validateEmptyName(String nameValue) {
        if (nameValue.trim().isEmpty()) {
            throw new PlayerNameEmptyException("Player's name must not be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return location == player.location &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
