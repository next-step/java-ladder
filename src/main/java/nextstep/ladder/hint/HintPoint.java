package nextstep.ladder.hint;

public class HintPoint {
    private final int index;
    private final HintDirection hintDirection;

    public HintPoint(final int index, final HintDirection hintDirection) {
        this.index = index;
        this.hintDirection = hintDirection;
    }

    public int move() {
        if (hintDirection.isRight()) {
            return index + 1;
        }

        if (hintDirection.isLeft()) {
            return index - 1;
        }
        return this.index;
    }

    public HintPoint next() {
        return new HintPoint(index + 1, hintDirection.next());
    }

    public HintPoint next(final Boolean right) {
        return new HintPoint(index + 1, hintDirection.next(right));
    }

    public HintPoint last() {
        return new HintPoint(index + 1, hintDirection.last());
    }

    public static HintPoint first(final Boolean right) {
        return new HintPoint(0, HintDirection.first(right));
    }

    public boolean isLeft() {
        return hintDirection.isLeft();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", index, hintDirection);
    }
}
