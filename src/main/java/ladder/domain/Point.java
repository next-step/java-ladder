package ladder.domain;

public class Point {
    private Position position;
    private Direction direction;

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


    public Point move() {
        return new Point(Position.increase(),direction.next());
    }

    public int getPosition(){
        return position.getPosition();
    }
}
