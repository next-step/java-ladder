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
            if (zeroRightCheck(lines)) {
                return;
            }
            if (betweenLeftOrRightCheck(linesList, lines)) {
                return;
            }
            maxLeftCheck(linesList, lines);
        });

        return ceil();
    }

    private void maxLeftCheck(List<Lines> linesList, Lines lines) {
        if (!isMax(linesList)) return;
        if (!isLeft(lines, moveIndex)) return;
        leftMove();
    }

    private boolean betweenLeftOrRightCheck(List<Lines> linesList, Lines lines) {
        if (isBetween(linesList)) {

            if (isLeft(lines, moveIndex)) {
                leftMove();
                return true;
            }

            if (isRight(lines, moveIndex)) {
                rightMove();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean zeroRightCheck(Lines lines) {
        if (isZero()) {
            if (isRight(lines, moveIndex)) {
                rightMove();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean isLeft(Lines lines, int index) {

        Predicate<Lines> match = lines1 -> lines1.findLines(index - 1).isExist();
        return match.test(lines);
    }

    private boolean isRight(Lines lines, int index) {

        Predicate<Lines> match = lines1 -> lines1.findLines(index + 1).isExist();
        return match.test(lines);
    }
}
