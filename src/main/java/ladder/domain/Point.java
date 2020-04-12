package ladder.domain;

public class Point {
    private final int heightPosition;
    private final Direction direction;

    public Point(int heightPosition, Direction direction) {
        this.heightPosition = heightPosition;
        this.direction = direction;
    }

    public int move(int currentIndex) {
        return direction.next(currentIndex);
    }

    public boolean isHeightPosition(int heightPosition) {
        return this.heightPosition == heightPosition;
    }

    public boolean isDirection(Direction direction){
        return this.direction.equals(direction);
    }
}
