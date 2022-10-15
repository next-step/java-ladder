package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.PartLineCreateStrategy;
import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;

public class Point {
    private final Position position;
    private final Direction direction;
    
    private Point(final Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }
    
    public static Point createFirst(PartLineCreateStrategy partLineCreateStrategy) {
        return new Point(new Position(0), Direction.createFirst(partLineCreateStrategy));
    }
    
    public Point createLast() {
        return new Point(position.createNext(), direction.createLast());
    }
    
    public Point createNext(PartLineCreateStrategy partLineCreateStrategy) {
        return new Point(position.createNext(), direction.createNext(partLineCreateStrategy));
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
