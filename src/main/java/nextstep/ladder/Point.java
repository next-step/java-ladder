package nextstep.ladder;

public class Point {
    private final Direction direction;

    public Point(){
        this.direction = Direction.STOP;
    }

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }

    public Point next(){
        return new Point(Direction.makeDirection(direction));
    }
}
