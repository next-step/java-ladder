package ladder.step2.domain;

public class Point {
    private final Position position;
    private final Direction direction;
    
    public Point(final Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }
    
    public static Point createFirst() {
        return new Point(new Position(0), Direction.createFirst());
    }
    
    public Point createLast() {
        return new Point(position.createNext(), direction.createLast());
    }
    
    public Point createNext() {
        return new Point(position.createNext(), direction.createNext());
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
