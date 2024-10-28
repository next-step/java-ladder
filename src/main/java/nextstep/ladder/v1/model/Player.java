package nextstep.ladder.v1.model;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException("name must not be longer than 5");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
