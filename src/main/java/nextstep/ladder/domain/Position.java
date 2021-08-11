package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Predicate;

public class Position {
    private static final int MAKE_MAX_INDEX = 1;
    private static final int MOVING_INDEX = 2;

    private int moveIndex;

    private Position(int moveIndex) {
        this.moveIndex = moveIndex;
    }

    public static Position of(int moveIndex) {
        return new Position(moveIndex);
    }

    private void rightMove() {
        this.moveIndex += MOVING_INDEX;
    }

    private void leftMove() {
        this.moveIndex -= MOVING_INDEX;
    }

    private int ceil() {
        return (int) Math.ceil(moveIndex / MOVING_INDEX);
    }

    private boolean isZero() {
        return moveIndex == MAKE_MAX_INDEX;
    }

    private boolean isBetween(List<Lines> linesList) {
        return moveIndex > 1 && moveIndex < linesList.get(0).size() - MAKE_MAX_INDEX;
    }

    private boolean isMax(List<Lines> linesList) {
        return moveIndex == linesList.get(0).size() - MAKE_MAX_INDEX;
    }

    public int run(List<Lines> linesList) {
        linesList.forEach(lines -> {
            if (isZero(lines)) {
                return;
            }
            if (isBetween(linesList, lines)) {
                return;
            }
            isMax(linesList, lines);
        });

        return ceil();
    }

    private void isMax(List<Lines> linesList, Lines lines) {
        if (isMax(linesList)) {
            if (leftMove(lines, moveIndex)) {
                leftMove();
            }
        }
    }

    private boolean isBetween(List<Lines> linesList, Lines lines) {
        if (isBetween(linesList)) {

            if (leftMove(lines, moveIndex)) {
                leftMove();
                return true;
            }

            if (rightMove(lines, moveIndex)) {
                rightMove();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isZero(Lines lines) {
        if (isZero()) {
            if (rightMove(lines, moveIndex)) {
                rightMove();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean leftMove(Lines lines, int index) {

        Predicate<Lines> match = lines1 -> lines1.findLines(index - 1).isExist();
        return match.test(lines);
    }

    private boolean rightMove(Lines lines, int index) {

        Predicate<Lines> match = lines1 -> lines1.findLines(index + 1).isExist();
        return match.test(lines);
    }
}
