package ladder.domain;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class Player {
    private static final int NAME_LENGTH_MAX = 5;
    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수값입니다.");
        }

        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("이름은 최대 5자리입니다.");
        }
    }

    public long nameLength() {
        return name.length();
    }

    public String name() {
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
        return name;
    }
}
