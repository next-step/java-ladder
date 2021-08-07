package ladder.domain.point;

public final class LadderPoint {
    private final int index;
    private final Direction direction;

    public LadderPoint(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
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

    public boolean isEmpty() {
        return direction.isEmpty();
    }

    public boolean checkIndex(final int index) {
        return this.index == index;
    }
}
