package ladder.domain;

import java.util.Objects;

public class Player {
    private final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    private Player(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("참가자 이름은 최대 5자 이내입니다.");
        }
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
