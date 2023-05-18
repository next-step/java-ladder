package refactoring.domain;

import java.util.Objects;

public class Player {

    private final int index;
    private final Name name;
    private final Direction direction;

    public Player(
        final String name,
        final int index,
        final Direction direction
    ) {
        this.name = new Name(name);
        this.index = index;
        this.direction = direction;
    }

    public Player(
        final Name name,
        final int index,
        final Direction direction
    ) {
        this.name = name;
        this.index = index;
        this.direction = direction;
    }

    public static Player first(final String name, final LineStatus currentStatus) {
        return new Player(name, 0, Direction.first(currentStatus));
    }

    public Player last(String name) {
        return new Player(name, index + 1, direction.last());
    }

    public Player next(final String name) {
        return new Player(name, index + 1, direction.next());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return index == player.index && Objects.equals(name, player.name)
            && Objects.equals(direction, player.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name, direction);
    }


    public int move() {
        return index + direction.move();
    }
}
