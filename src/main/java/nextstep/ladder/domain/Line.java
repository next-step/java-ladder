package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Line {
    private final List<LadderMoveDirection> points;
    private final Rungs rungs;

    public Line(final int pointsSize, final BooleanSupplier lineBuilderStrategy) {
        final int rungsWidth = pointsSize - 1;
        this.rungs = new Rungs(rungsWidth, lineBuilderStrategy);

        this.points = convertRungsToPoints(pointsSize);
    }

    private List<LadderMoveDirection> convertRungsToPoints(final int pointsSize) {
        if (this.rungs == null) {
            throw new IllegalStateException("hasRung is needed to initiate points");
        }

        final List<LadderMoveDirection> tempPoints = new ArrayList<>();

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
        return this.rungs.rungs();
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
        return this.rungs.hasRungAtIdx(curPointIdx);
    }

    private boolean isLastPointIdx(final int pointIdx) {
        final int pointsSize = this.rungs.size() + 1;

        return pointIdx == pointsSize - 1;
    }

    private LadderMoveDirection selectDirectionWhenLastIdx(final int curPointIdx) {
        if (hasLeftSideRungAtCurPointIdx(curPointIdx)) {
            return LadderMoveDirection.LEFT;
        }

        return LadderMoveDirection.CENTER;
    }

    private boolean hasLeftSideRungAtCurPointIdx(final int curPointIdx) {
        return this.rungs.hasRungAtIdx(curPointIdx - 1);
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
