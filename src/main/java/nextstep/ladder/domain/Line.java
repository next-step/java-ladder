package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Line {
    private final List<LadderMoveDirection> points;
    private final Boolean[] hasRung;

    public Line(final int width, final BooleanSupplier lineBuilderStrategy) {
        this.hasRung = buildBooleanArray(width, lineBuilderStrategy);

        this.points = convertLineToPoints();
    }

    private Boolean[] buildBooleanArray(final int width, final BooleanSupplier lineBuilderStrategy) {
        final Boolean[] tempBooleans = new Boolean[width];

        tempBooleans[0] = lineBuilderStrategy.getAsBoolean();

        for (int idx = 1; idx < tempBooleans.length; idx++) {
            final boolean preBool = tempBooleans[idx - 1];
            final boolean curBool = lineBuilderStrategy.getAsBoolean();

            tempBooleans[idx] = adjustContinuousTrue(preBool, curBool);
        }

        return tempBooleans;
    }

    private boolean adjustContinuousTrue(final boolean preBool, boolean curBool) {
        if (preBool) {
            curBool = false;
        }

        return curBool;
    }

    private List<LadderMoveDirection> convertLineToPoints() {
        if (this.hasRung == null) {
            throw new IllegalStateException("hasRung is needed to initiate points");
        }

        final List<LadderMoveDirection> tempPoints = new ArrayList<>();
        final int pointsSize = this.hasRung.length + 1;

        for (int curPointIdx = 0; curPointIdx < pointsSize; curPointIdx++) {
            tempPoints.add(selectDirection(curPointIdx));
        }

        return tempPoints;
    }

    private LadderMoveDirection selectDirection(final int curPointIdx) {
        if (isFirstPointIdx(curPointIdx)) {
            return selectDirectionWhenFirstIdx(curPointIdx);
        }

        if (isLastPointIdx(curPointIdx)) {
            return selectDirectionWhenLastIdx(curPointIdx);
        }

        return selectDirectionWhenNormalIdx(curPointIdx);
    }


    public Boolean[] getHasRung() {
        return this.hasRung;
    }

    private boolean isFirstPointIdx(final int pointIdx) {
        return pointIdx == 0;
    }

    private LadderMoveDirection selectDirectionWhenFirstIdx(final int curPointIdx) {
        if (hasRightSideRungAtCurPointIdx(curPointIdx)) {
            return LadderMoveDirection.RIGHT;
        }

        return LadderMoveDirection.CENTER;
    }

    private boolean hasRightSideRungAtCurPointIdx(final int curPointIdx) {
        return this.hasRung[curPointIdx];
    }

    private boolean isLastPointIdx(final int pointIdx) {
        final int pointsSize = this.hasRung.length + 1;

        return pointIdx == pointsSize - 1;
    }

    private LadderMoveDirection selectDirectionWhenLastIdx(final int curPointIdx) {
        if (hasLeftSideRungAtCurPointIdx(curPointIdx)) {
            return LadderMoveDirection.LEFT;
        }

        return LadderMoveDirection.CENTER;
    }

    private boolean hasLeftSideRungAtCurPointIdx(final int curPointIdx) {
        return this.hasRung[curPointIdx - 1];
    }

    private LadderMoveDirection selectDirectionWhenNormalIdx(final int curPointIdx) {
        if (hasLeftSideRungAtCurPointIdx(curPointIdx)) {
            return LadderMoveDirection.LEFT;
        }

        if (hasRightSideRungAtCurPointIdx(curPointIdx)) {
            return LadderMoveDirection.RIGHT;
        }

        return LadderMoveDirection.CENTER;
    }

    public int move(final int userIdx) {
        final LadderMoveDirection direction = this.points.get(userIdx);

        return direction.move(userIdx);
    }
}
