package ladder.domain;

public class Point {
    private final Position position;
    private final Direction direction;

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(Position.first(), Direction.first(right));
    }

    public static Point first() {
        return new Point(Position.first(), Direction.first());
    }

    public Point next() {
        return new Point(this.position.increase(), this.direction.next());
    }

    public Point last() {
        return new Point(this.position.increase(), this.direction.last());
    }

    public Position move(Position position) {
        return this.direction.move(position);
    }
    
    public String isLine() {
    	return direction.isLine();
    }

}
