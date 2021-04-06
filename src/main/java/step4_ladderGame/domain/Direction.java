package step4_ladderGame.domain;

import step4_ladderGame.exception.ContinuousLadderCreateException;

import java.util.Arrays;

public enum Direction {

    RIGHT(false, true),
    LEFT(true, false),
    STOP(false, false);

    private final boolean prev;
    private final boolean current;

    Direction(boolean prev, boolean current) {
        this.prev = prev;
        this.current = current;
    }

    public static Direction valueOf(boolean prev, boolean current) {
        return Arrays.stream(Direction.values()).
                filter(direction -> direction.same(prev, current))
                .findAny()
                .orElseThrow(() -> new ContinuousLadderCreateException("연속된 사다리 연결 point 생성은 불가합니다."));
    }

    private boolean same(boolean prev, boolean current) {
        return this.prev == prev && this.current == current;
    }
}
