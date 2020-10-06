package nextstep.ladder.domain;

import java.util.Objects;

public class Lane {

    private final int index;

    private Lane(int index) {
        this.index = index;
    }

    public static Lane of(int index) {
        validateIndex(index);
        return new Lane(index);
    }

    private static void validateIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index는 0 이상의 값이어야 합니다.");
        }
    }

    public Lane move(Line line) {
        Direction direction = line.move(index);
        return direction.changeLane(index);
    }

    public Lane copy() {
        return new Lane(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lane lane = (Lane) o;
        return index == lane.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
