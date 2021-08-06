package ladder.domain.point;

public final class LadderPoint {
    private static DirectionCreateStrategy directionCreateStrategy = new UnconnectedRandomDirectionCreateStrategy();

    private final int index;
    private final Direction direction;

    private LadderPoint(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static LadderPoint first() {
        return new LadderPoint(0, directionCreateStrategy.first());
    }

    public static void setDirectionCreateStrategy(DirectionCreateStrategy directionCreateStrategy) {
        LadderPoint.directionCreateStrategy = directionCreateStrategy;
    }

    public LadderPoint next() {
        return newLinkPoint(directionCreateStrategy.next(direction));
    }

    public LadderPoint last() {
        return newLinkPoint(directionCreateStrategy.last(direction));
    }

    private LadderPoint newLinkPoint(final Direction direction) {
        return new LadderPoint(index + 1, direction);
    }

    public int move(final int index) {
        if (isLeft()) {
            return index - 1;
        }
        if (isRight()) {
            return index + 1;
        }
        return index;
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    public boolean checkIndex(final int index) {
        return this.index == index;
    }
}
