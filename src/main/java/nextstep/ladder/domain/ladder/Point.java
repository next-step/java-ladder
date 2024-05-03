package nextstep.ladder.domain.ladder;

import static nextstep.ladder.domain.ladder.Direction.*;

import java.util.Objects;
import nextstep.ladder.domain.generator.ValueGenerator;

public class Point {

    private final Boolean left;
    private final Boolean right;

    private Point(Boolean left, Boolean right) {
        validPoint(left, right);

        this.left = left;
        this.right = right;
    }

    public static Point of(Boolean left, Boolean right) {
        return new Point(left, right);
    }

    public static Point first(ValueGenerator generator) {
        return new Point(false, generator.generate());
    }

    public Point next(Boolean right){
        if(this.right){
            return new Point(true, false);
        }
        return new Point(false, right);
    }
    public Point next(ValueGenerator generator) {
        return next(generator.generate());
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public boolean isConnected(){
        return this.right;
    }

    private static void validPoint(Boolean left, Boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }


    public Direction move() {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return PASS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(left, point.left) && Objects.equals(right,
            point.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
