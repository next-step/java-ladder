package ladder.step2.domain;

public class Point {
    private final boolean leftPoint;
    private final boolean rightPoint;
    
    public Point(final boolean leftPoint, final boolean rightPoint) {
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }
    
    public Direction move() {
        if (rightPoint) {
            return Direction.RIGHT;
        }
        
        if (leftPoint) {
            return Direction.LEFT;
        }
        
        return Direction.SOUTH;
    }
}
