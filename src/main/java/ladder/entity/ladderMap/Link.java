package ladder.entity.ladderMap;

import ladder.entity.moveStrategy.MoveStrategy;

public class Link {
    private final Point from;
    private final Point to;

    public Link(Point from, MoveStrategy moveStrategy) {
        this.from = from;
        this.to = from.move(moveStrategy);
    }

    public boolean staysStill(){
        return this.from==this.to;
    }

    public boolean goesRight(){
        return this.to.isGreaterThan(this.from);
    }

    public Point from() {
        return from;
    }

    public Point to() {
        return to;
    }
}
