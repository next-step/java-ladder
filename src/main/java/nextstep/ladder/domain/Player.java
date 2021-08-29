package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(Name name, Position givenStartPosition) {
        return new Player(name, givenStartPosition);
    }

    public String name() {
        return name.name();
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return position == player.position && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
