package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {
    public static final Random RANDOM = new Random();
    public static final int RANDOM_END = 10;

    public static final int RANDOM_BOUNDARY = 5;

    private final Direction direction;
    private final int index;

    private Point(Direction direction, int index) {
        this.direction = direction;
        this.index = index;
    }

    public static Point of(Direction direction, int index) {
        return new Point(direction, index);
    }

    public static Point randomFirstPoint() {
        int randomNumber = RANDOM.nextInt(RANDOM_END);
        if (randomNumber > RANDOM_BOUNDARY) {
            return Point.of(new Direction("right"), 0);
        } else if (randomNumber <= RANDOM_BOUNDARY) {
            return Point.of(new Direction("none"), 0);
        }
        throw new IllegalArgumentException("first point 생성 불가능");
    }

    public static Point randomLastPoint(Point previousPoint, int index) {
        int randomNumber = RANDOM.nextInt(RANDOM_END);

        if (previousPoint.direction.isRight()) {
            return Point.of(new Direction("left"), index);
        }
        if (previousPoint.direction.isLeft()) {
            return Point.of(new Direction("none"), index);
        }
        if (previousPoint.direction.isNone() && randomNumber <= RANDOM_BOUNDARY) {

            return Point.of(new Direction("left"), index);
        }
        if (previousPoint.direction.isNone() && randomNumber > RANDOM_BOUNDARY) {
            return Point.of(new Direction("none"), index);
        }
        throw new IllegalArgumentException("last point 생성 불가능");
    }

    public Point nextPoint(int index) {
        int randomNumber = RANDOM.nextInt(RANDOM_END);
        if (this.direction.isRight()) {
            return Point.of(new Direction("left"), index);
        }
        if ((this.direction.isLeft() || this.direction.isNone()) && randomNumber <= RANDOM_BOUNDARY) {

            return Point.of(new Direction("right"), index);
        }
        if ((this.direction.isLeft() || this.direction.isNone()) && randomNumber > RANDOM_BOUNDARY) {
            return Point.of(new Direction("none"), index);
        }
        throw new IllegalArgumentException("next point 생성 불가능");
    }

    public Direction getDirection() {
        return direction;
    }

    public int move() {
        if (this.direction.isRight()) {
            return index + 1;
        }
        if (this.direction.isLeft()) {
            return index - 1;
        }
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
