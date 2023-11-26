package nextstep.ladder.domain;

import java.util.Arrays;
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

        final LadderMoveDirection[] tempPoints = initPoints(pointsSize);

        calculateDirections(tempPoints);

        return List.of(tempPoints);
    }

    private LadderMoveDirection[] initPoints(final int pointsSize) {
        final LadderMoveDirection[] tempPoints = new LadderMoveDirection[pointsSize];
        Arrays.fill(tempPoints, LadderMoveDirection.CENTER);

        return tempPoints;
    }

    private void calculateDirections(final LadderMoveDirection[] tempPoints) {
        final int pointsSize = tempPoints.length;
        int curPointIdx = 0;

        while (curPointIdx < pointsSize) {
            curPointIdx = calculateDirectionAtPointIdx(curPointIdx, tempPoints);
        }
    }

    private int calculateDirectionAtPointIdx(int curPointIdx, final LadderMoveDirection[] tempPoints) {
        final int lastIdx = tempPoints.length - 1;

        if (isNormalIdx(curPointIdx, lastIdx) && hasRightSideRung(curPointIdx)) {
            tempPoints[curPointIdx++] = LadderMoveDirection.RIGHT;
            tempPoints[curPointIdx] = LadderMoveDirection.LEFT;

            return curPointIdx + 1;
        }

        if (isLastIdx(curPointIdx, lastIdx) && hasLeftSideRung(curPointIdx)) {
            tempPoints[curPointIdx] = LadderMoveDirection.LEFT;
        }

        return curPointIdx + 1;
    }

    private boolean isNormalIdx(final int curPointIdx, final int lastIdx) {
        return curPointIdx != lastIdx;
    }

    private boolean isLastIdx(final int curPointIdx, final int lastIdx) {
        return !isNormalIdx(curPointIdx, lastIdx);
    }

    private boolean hasRightSideRung(final int curPointIdx) {
        return this.rungs.hasRungAtIdx(curPointIdx);
    }

    private boolean hasLeftSideRung(final int curPointIdx) {
        return this.rungs.hasRungAtIdx(curPointIdx - 1);
    }

    public Boolean[] getHasRung() {
        return this.rungs.rungs();
    }

    public int move(final int userIdx) {
        final LadderMoveDirection direction = this.points.get(userIdx);

        return direction.move(userIdx);
    }
}
