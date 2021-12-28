package nextstep.ladder.domain;

/**
 * @author han
 */
public class Position {
    private static final int FORWARD = 1;

    private final int index;
    private final User user;

    public Position(int index, User user) {
        this.index = index;
        this.user = user;
    }

    public static Position of(Position position) {
        return new Position(position.getIndex(), position.getUser());
    }

    public Position move(Point point) {
        Direction move = point.move();

        if (move.equals(Direction.LEFT)) {
            return new Position(index - FORWARD, this.user);
        }

        if (move.equals(Direction.RIGHT)) {
            return new Position(index + FORWARD, this.user);
        }

        return this;
    }

    public int getIndex() {
        return index;
    }

    public User getUser() {
        return user;
    }
}
