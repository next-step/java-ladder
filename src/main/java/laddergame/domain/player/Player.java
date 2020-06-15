package laddergame.domain.player;

import java.util.Objects;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int column) {
        this.name = new Name(name);
        this.position = new Position(column);
    }

    public String getName() {
        return this.name.getName();
    }

    public boolean isSameName(String name) {
        return Objects.equals(getName(), name);
    }

    public int getCurrentHeight() {
        return this.position.getHeight();
    }

    public int getCurrentColumn() {
        return this.position.getColumn();
    }
}
