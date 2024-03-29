package nextstep.ladder.model;

import java.util.Objects;

public class Player {
    private final Name name;
    private Position position;

    public Player(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveTo(Direction direction) {
        this.position = this.position.moveTo(direction);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Player player = (Player) other;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
