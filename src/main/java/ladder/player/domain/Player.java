package ladder.player.domain;

import java.util.Objects;

public class Player {
    private static final String BANNED_NAME = "all";
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
        if (BANNED_NAME.equalsIgnoreCase(name)) {
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
        return Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
