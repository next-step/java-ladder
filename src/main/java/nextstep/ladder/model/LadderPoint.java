package nextstep.ladder.model;

public final class LadderPoint {
    private final int index;
    private final PointDirection direction;

    private LadderPoint(int index, PointDirection direction) {
        this.index = index;
        this.direction = direction;
    }

    public LadderPoint next() {
        return new LadderPoint(index + 1, direction.next());
    }

    public LadderPoint last() {
        return new LadderPoint(index + 1, direction.last());
    }

    public static LadderPoint first(Boolean right) {
        return new LadderPoint(0, PointDirection.first(right));
    }

    public PointDirection getDirection() {
        return direction;
    }
}
