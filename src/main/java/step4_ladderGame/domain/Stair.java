package step4_ladderGame.domain;

public class Stair {

    private final Position position;
    private final Point point;

    private Stair(Position position, Point point) {
        this.position = position;
        this.point = point;
    }

    public static Stair of(int position, Point point) {
        return new Stair(Position.of(position), point);
    }

    public static Stair of(Position position, Point point) {
        return new Stair(position, point);
    }

    public Position move() {
        if (point.move() == Direction.RIGHT) {
            return position.right();
        }
        if (point.move() == Direction.LEFT) {
            return position.left();
        }
        return position;
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
    }

    // false ture  true false  false ture  true false
    public boolean toDto() {
        return point.current();
    }
}
