package ladder.domain;

public class Point {

    private static final String BAR    = "|-----";
    private static final String PILLAR = "|     ";

    private final Direction direction;

    private Point(Direction direction) {
        this.direction = direction;
    }

    public static Point first(BarCreator barCreator) {
        return new Point(Direction.leftCorner(barCreator.create()));
    }

    public static Point next(Direction prevDirection, BarCreator barCreator) {
        return new Point(Direction.of(prevDirection, barCreator.create()));
    }

    public static Point last(Direction prevDirection) {
        return new Point(Direction.rightCorner(prevDirection));
    }

    @Override
    public String toString() {

        if (direction.isRight()) {
            return BAR;
        }

        return PILLAR;
    }

    public int move() {
        return direction.move();
    }

    public Direction getDirection() {
        return direction;
    }
}
