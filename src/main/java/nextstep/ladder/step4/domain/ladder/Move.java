package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Move {

    LEFT(-1), STOP(0), RIGHT(1);

    private static final Map<Direction, Move> MOVE_MAP;

    static {
        MOVE_MAP = new HashMap<>();
        MOVE_MAP.put(Direction.first(TRUE).last(), LEFT);
        MOVE_MAP.put(Direction.first(FALSE).last(), STOP);
        MOVE_MAP.put(Direction.first(FALSE).next(TRUE), RIGHT);
    }

    private final int move;

    Move(int move) {
        this.move = move;
    }

    public static Move of(Direction direction) {
        return Optional.of(MOVE_MAP.get(direction))
            .orElseThrow(() -> new IllegalArgumentException("이동할 수 없는 경로 입니다."));
    }

    public int move(int index) {
        return index + this.move;
    }

}
