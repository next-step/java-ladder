package nextstep.ladder.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    public static final int MIN_POSITION = -1;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException("포지션의 위치는 -1보다 작을 수 없습니다");
        }

        return new Position(position);
    }

    public boolean canGoRight(int maxSize) {
        return position + 1 <= maxSize;
    }

    public boolean canGoLeft() {
        return position - 1 > MIN_POSITION;
    }

    public Position toLeft() {
        return from(position - 1);
    }

    public Position toRight() {
        return from(position + 1);
    }

    public int currentPosition() {
        return position;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.position, other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }


}
