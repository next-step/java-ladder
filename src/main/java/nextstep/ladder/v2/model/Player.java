package nextstep.ladder.v2.model;

import java.util.Objects;

public class Player {
    private String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Name is too long");
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
