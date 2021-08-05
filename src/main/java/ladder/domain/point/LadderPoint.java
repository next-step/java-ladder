package ladder.domain.point;

public final class LadderPoint {
    private final int index;
    private final Direction direction;

    private LadderPoint(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static LadderPoint first() {
        return new LadderPoint(0, Direction.first());
    }

    public LadderPoint next() {
        return newLinkPoint(direction.next());
    }

    public LadderPoint last() {
        return newLinkPoint(direction.last());
    }

    private LadderPoint newLinkPoint(final Direction direction) {
        return new LadderPoint(index + 1, direction);
    }

    public int move(final int index) {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public boolean checkIndex(final int index) {
        return this.index == index;
    }
}
