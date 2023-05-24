package nextstep.ladder.domain.line.move;

import nextstep.ladder.domain.line.Line;


public class MovingStrategy {

    private static final int NEXT_MOVE = 1;

    public static int move(Line line, int position) {
        if (moveLeft(line, position)) {
            return position - NEXT_MOVE;
        }
        if (moveRight(line, position)) {
            return position + NEXT_MOVE;
        }
        return position;
    }

    private static boolean moveLeft(Line line, int position) {
        if (line.isLefEnd(position)) {
            return false;
        }

        return (line.isNotEnd(position - NEXT_MOVE) && line.hasLine(position - NEXT_MOVE));
    }

    private static boolean moveRight(Line line, int position) {
        if (line.isRightEnd(position)) {
            return false;
        }
        return (line.isNotEnd(position + NEXT_MOVE) && line.hasLine(position));
    }
}
