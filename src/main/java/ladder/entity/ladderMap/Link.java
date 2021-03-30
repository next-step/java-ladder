package ladder.entity.ladderMap;

import ladder.entity.moveStrategy.MoveStrategy;

public class Link {
    private final Point from;
    private final Point to;

    public Link(Point from, MoveStrategy moveStrategy) {
        this.from = from;
        this.to = from.move(moveStrategy);
    }

    public Point from() {
        return from;
    }

    public Point to() {
        return to;
    }
}
