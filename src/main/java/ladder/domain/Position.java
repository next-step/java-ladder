package ladder.domain;

import java.util.List;

public final class Position {
    private static final int INITIAL_FLOOR = 0;
    private final int x;
    private final int y;

    Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    Position(final int x) {
        this(x, INITIAL_FLOOR);
    }
}
