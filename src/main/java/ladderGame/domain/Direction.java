package ladderGame.domain;

import java.util.EnumSet;

public enum Direction {

    RIGHT(0),
    STRAIGHT(1),
    LEFT(2);

    private int identity;

    Direction(int identity) {
        this.identity = identity;
    }

    public static Direction of(int number) {
        return EnumSet.allOf(Direction.class).stream()
                .filter(Direction -> Direction.identity == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("방향의 종류를 넘어선 숫자 생성"));
    }

}
