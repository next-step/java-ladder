package nextstep.ladder.domain;

public class ImprovingPoint {
    private final static int CHANGE_INDEX = 1;
    private final int index;
    private final Direction direction;

    public ImprovingPoint(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isRight()) {
            return index + CHANGE_INDEX;
        }

        if (direction.isLeft()) {
            return index - CHANGE_INDEX;
        }

        return index;
    }

    public ImprovingPoint next(boolean right) {
        return new ImprovingPoint(index + CHANGE_INDEX, direction.next(right));
    }

    public ImprovingPoint last() {
        return new ImprovingPoint(index + CHANGE_INDEX, direction.last());
    }

    public static ImprovingPoint first(boolean right) {
        return new ImprovingPoint(0, Direction.first(right));
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "ImprovingPoint{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
