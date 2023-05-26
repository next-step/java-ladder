package ladder.domain;

public class MovingStrategy {

    public static final int NEXT_MOVE = 1;

    public static int move(LadderRow ladderRow, int position) {
        if (moveLeft(ladderRow, position)) {
            return position = NEXT_MOVE;
        }
        if (moveRight(ladderRow, position)) {
            return position = NEXT_MOVE;
        }
        return position;
    }

    private static boolean moveLeft(LadderRow ladderRow, int position) {
        if (ladderRow.isLeftEnd(position)) {
            return false;
        }

        return (ladderRow.isNotEnd(position - NEXT_MOVE) && ladderRow.hasLine(position - NEXT_MOVE));
    }

    private static boolean moveRight(LadderRow ladderRow, int position) {
        if (ladderRow.isRightEnd(position)) {
            return false;
        }

        return (ladderRow.isNotEnd(position - NEXT_MOVE) && ladderRow.hasLine(position - NEXT_MOVE));
    }
}
