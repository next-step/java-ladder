package nextstep.ladder.model.ladder;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.model.ConstantNumber.ONE;
import static nextstep.ladder.model.ConstantNumber.ZERO;

public class Point {

    private final Direction direction;
    private final int index;
    private final boolean value;

    private Point(Direction direction, int index) {
        this.direction = direction;
        this.index = index;
        this.value = false;
    }

    public static Point of(boolean value) {
        return new Point(Direction.of(FALSE, value), ZERO.getValue());
    }

    public static Point first(boolean right) {
        return new Point(Direction.first(right), ZERO.getValue());
    }

    public Point last() {
        return new Point(direction.last(), Math.addExact(this.index, ONE.getValue()));
    }

    public int move() {
        if (this.direction.isRight()) {
            return Math.addExact(this.index, ONE.getValue());
        }

        if (this.direction.isLeft()) {
            return Math.subtractExact(this.index, ONE.getValue());
        }

        return this.index;
    }

    public Point next() {
        return new Point(this.direction.next(), Math.addExact(this.index, ONE.getValue()));
    }


    public Point next(boolean right) {
        return new Point(this.direction.next(right), Math.addExact(this.index, ONE.getValue()));
    }

    public Direction direction() {
        return this.direction;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
