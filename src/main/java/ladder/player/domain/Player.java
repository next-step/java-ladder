package ladder.player.domain;

import java.util.Objects;

import static ladder.Application.END_CONDITION;

public class Player {
    private static final int NAME_LENGTH_START = 0;
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    private Player(String name) {
        this.name = trimAndValidate(name);
    }

    public static Player of(String name) {
        return new Player(name);
    }

    private String trimAndValidate(String name) {
        if (END_CONDITION.equalsIgnoreCase(name)) {
            throw new BannedNameException();
        }
        if (name.length() > NAME_LENGTH_LIMIT) {
            return name.substring(NAME_LENGTH_START, NAME_LENGTH_LIMIT);
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
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
