package nextstep.ladder.model;

public final class LadderPoint {
    private static final int INIT_INDEX = 0;
    private static final int INCREMENT_UNIT_INDEX = 1;

    private final int index;
    private final PointDirection direction;

    private LadderPoint(int index, PointDirection direction) {
        this.index = index;
        this.direction = direction;
    }

    public static LadderPoint first(Boolean right) {
        return new LadderPoint(INIT_INDEX, PointDirection.first(right));
    }

    public LadderPoint next() {
        return new LadderPoint(index + INCREMENT_UNIT_INDEX, direction.next());
    }

    public LadderPoint last() {
        return new LadderPoint(index + INCREMENT_UNIT_INDEX, direction.last());
    }

    public PointDirection getDirection() {
        return direction;
    }

    public int move() {
        return direction.move(index);
    }
}
