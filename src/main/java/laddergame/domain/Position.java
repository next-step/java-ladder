package laddergame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int value;

    public Position(final int value) {
        if(value < 0){
            throw new IllegalArgumentException("사다리 게임의 위치는 0이상이어야 합니다");
        }
        this.value = value;
    }

    public boolean same(int otherValue) {
        return this.equals(new Position(otherValue));
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public int getValue() {
        return value;
    }
}
