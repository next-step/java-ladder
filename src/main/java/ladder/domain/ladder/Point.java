package ladder.domain.ladder;

public final class Point {

    private final int position;
    private final Direction direction;

    public Point(final int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public final int move() {
        Heading heading = direction.move();
        return heading.go(position);
    }

}
