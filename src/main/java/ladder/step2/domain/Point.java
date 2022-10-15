package ladder.step2.domain;

public class Point {
    private final Position position;
    private final Direction direction;
    
    public Point(final Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }
    
    public int move() {
        if (direction.isLeft()) {
            return position.moveLeft();
        }
        
        if (direction.isRight()) {
            return position.moveRight();
        }
    
        return position.pass();
    }
}
