package nextstep.ladder.domain;

import nextstep.ladder.generator.PositionGenerator;

public class Position {
    private static final int INCREASE_VALUE = 1;
    private static final int INITIAL_POSITION = 0;

    private final int value;
    private final Direction direction;

    public Position(int index, Direction direction) {
        this.value = index;
        this.direction = direction;
    }

    public int ride() {
        if(direction.isRight()) {
            return value + INCREASE_VALUE;
        }

        if(direction.isLeft()) {
            return value - INCREASE_VALUE;
        }

        return this.value;
    }

    public Position next(PositionGenerator positionGenerator) {
        return new Position(value + INCREASE_VALUE, direction.next(positionGenerator));
    }

    public Position next(boolean right) {
        return new Position(value + INCREASE_VALUE, direction.next(right));
    }

    public static Position first(boolean right) {
        return new Position(INITIAL_POSITION, Direction.first(right));
    }

    public Position last() {
        return new Position(value + INCREASE_VALUE, direction.last());
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
