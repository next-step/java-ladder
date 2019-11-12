package nextstep.ladder.domain;

import nextstep.ladder.util.RandomGenerator;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-11 20:43
 */
class Point {

    private static final int INCREASE = 1;
    private static final int FIRST_POSITION = 0;
    private final boolean footrest;
    private final int currentPosition;

    private Point(int currentPosition, boolean footrest) {
        this.currentPosition = currentPosition;
        this.footrest = footrest;
    }

    static Point first() {
        return new Point(FIRST_POSITION, false);
    }

    Point next() {
        return new Point(currentPosition + INCREASE, RandomGenerator.generateBoolean());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return footrest == point.footrest &&
                currentPosition == point.currentPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(footrest, currentPosition);
    }
}
