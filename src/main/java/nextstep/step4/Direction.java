package nextstep.step4;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.CommonConstans.FALSE_LINE;
import static nextstep.ladder.CommonConstans.TRUE_LINE;
import static nextstep.step4.LadderPointGenerator.generatePoint;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }

        this.left = left;
        this.right = right;
//        System.out.println(this);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) { //오른쪽이 트루면  오른쪽으로 이동뒤 오른쪽 TRUE/FALSE 오른쪽이 펄스면 오른쪽이동뒤 FALSE / RANDOM
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {

        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }


    public String drawLine() {
        return (isRight()) ? TRUE_LINE : FALSE_LINE;
    }
}
