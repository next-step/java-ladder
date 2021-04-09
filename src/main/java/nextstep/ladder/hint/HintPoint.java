package nextstep.ladder.hint;

public class HintPoint {
    private final int index;
    private final HintDirection hintDirection;

    public HintPoint(int index, HintDirection hintDirection) {
        this.index = index;
        this.hintDirection = hintDirection;
    }

    public int move() {
        System.out.println("is left? " + hintDirection.isLeft());
        System.out.println("is right? " + hintDirection.isRight());

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

    public HintPoint next(Boolean right) {
        return new HintPoint(index + 1, hintDirection.next(right));
    }

    public HintPoint last() {
        return new HintPoint(index + 1, hintDirection.last());
    }

    public static HintPoint first(Boolean right) {
        return new HintPoint(0, HintDirection.first(right));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + hintDirection +
                '}';
    }
}
