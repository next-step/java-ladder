package nextstep.ladder.domain;

public class ImprovingPoint {
    private final int index;
    private final Direction direction;

    public ImprovingPoint(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return index;
    }

    public ImprovingPoint next() {
        return new ImprovingPoint(index + 1, direction.next());
    }

    public ImprovingPoint next(boolean right) {
        return new ImprovingPoint(index + 1, direction.next(right));
    }

    public ImprovingPoint last() {
        return new ImprovingPoint(index + 1, direction.last());
    }

    public static ImprovingPoint first(Boolean right) {
        return new ImprovingPoint(0, Direction.first(right));
    }

    @Override
    public String toString() {
        return "ImprovingPoint{" +
               "index=" + index +
               ", direction=" + direction +
               '}';
    }
}
