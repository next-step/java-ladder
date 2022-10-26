package ladder.domain;

import java.util.Objects;

public class Player {

    private final Name name;
    private final Coordinate coordinate;

    public Player(final Name name, final Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public Player(final String name, final int x, final int y) {
        this(new Name(name), new Coordinate(x, y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(coordinate, player.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinate);
    }
}
