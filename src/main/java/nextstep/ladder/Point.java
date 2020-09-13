package nextstep.ladder;

public class Point {
    private final Direction direction;

    public Point(){
        this.direction = Direction.STOP;
    }

    public Point(Point prevPoints) {
        Direction previousDirection = prevPoints.direction;
        this.direction = Direction.makeDirection(previousDirection);
    }

    public boolean isMoveAble(Point previousPoint){
        return previousPoint.direction == Direction.STOP;
    }

    public Direction getDirection(){
        return direction;
    }

}
