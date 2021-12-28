package nextstep.ladder.domain;

/**
 * @author han
 */
public class Position {
    private static final int FORWARD = 1;

    private final int index;
    private final Point point;
    private final User user;

    public Position(int index, Point point, User user) {
        this.index = index;
        this.point = point;
        this.user = user;
    }

    public static Position of(Position position, Point point) {
        return new Position(position.getIndex(), point, position.getUser());
    }

    public Position move() {
        Direction move = point.move();

        if (move.equals(Direction.LEFT)) {
            return new Position(index - FORWARD, this.point, this.user);
        }

        if (move.equals(Direction.RIGHT)) {
            return new Position(index + FORWARD, this.point, this.user);
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
