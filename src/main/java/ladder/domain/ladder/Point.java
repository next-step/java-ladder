package ladder.domain.ladder;

public final class Point {

    private final int position;
    private final Direction direction;

    public final static Point from(final int position, final Direction direction) {
        return new Point(position, direction);
    }

    public Point(final int position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public final int move() {
        Heading heading = direction.move();
        return heading.go(position);
    }


}
