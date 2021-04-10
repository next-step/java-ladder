package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Lane {

    private final int value;

    private Lane(int value) {
        this.value = value;
    }

    public static Lane wrap(int index) {
        validate(index);
        return new Lane(index);
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }

    public int unwrap() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lane)) return false;
        Lane lane = (Lane) o;
        return value == lane.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
