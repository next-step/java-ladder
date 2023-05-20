package refactoring.domain;

import static refactoring.domain.LineStatus.CONNECTION;
import static refactoring.domain.LineStatus.DETACHMENT;

public enum Movement {
    RIGHT(1), LEFT(-1), DOWN(0);

    private final int position;

    Movement(final int position) {
        this.position = position;
    }

    public static int next(LineStatus before, LineStatus current) {
        if (isRight(before, current)) {
            return RIGHT.position;
        }

        if (isLeft(before, current)) {
            return LEFT.position;
        }

        return DOWN.position;
    }

    private static boolean isLeft(final LineStatus before, final LineStatus current) {
        return before == CONNECTION && current == DETACHMENT;
    }

    private static boolean isRight(final LineStatus before, final LineStatus current) {
        return before == DETACHMENT && current == CONNECTION;
    }
}
