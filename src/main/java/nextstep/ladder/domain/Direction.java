package nextstep.ladder.domain;

import java.util.Arrays;

public enum Direction {
    LEFT(-1),
    STAY(0),
    RIGHT(1);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public static Direction of(int value) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.sameValue(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자 값에 따른 Direction을 찾을 수 없습니다."));
    }

    public boolean sameValue(int value) {
        return this.value == value;
    }

    public int move(int position) {
        return position + this.value;
    }

    public int getValue() {
        return value;
    }
}
