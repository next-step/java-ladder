package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Line {
    private final List<Boolean> points;

    public Line(final int width, final BooleanSupplier lineBuilderStrategy) {
        this.points = new ArrayList<>(width);

        for (int idx = 0; idx < width; idx++) {
            addPoint(idx, lineBuilderStrategy.getAsBoolean());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void addPoint(final int idx, boolean curPoint) {
        if (idx > 0) {
            boolean prePoint = this.points.get(idx - 1);

            curPoint = adjustContinuousTrue(prePoint, curPoint);
        }

        this.points.add(curPoint);
    }

    private boolean adjustContinuousTrue(final boolean prePoint, boolean curPoint) {
        if (prePoint) {
            return false;
        }

        return curPoint;
    }

    public int move(final int userIdx) {
        if (isUserFirstIdx(userIdx)) {
            return moveWhenFirstIdx(userIdx);
        }

        if (isUserLastIdx(userIdx)) {
            return moveWhenLastIdx(userIdx);
        }

        return moveWhenNormalIdx(userIdx);
    }

    private boolean isUserFirstIdx(final int userIdx) {
        return userIdx == 0;
    }

    private boolean isUserLastIdx(final int userIdx) {
        return points.size() == userIdx;
    }

    private int moveWhenNormalIdx(final int userIdx) {
        final int leftSideIdx = userIdx - 1;
        if (points.get(leftSideIdx)) {
            return userIdx - 1;
        }

        final int rightSideIdx = userIdx;
        if (points.get(rightSideIdx)) {
            return userIdx + 1;
        }

        return userIdx;
    }

    private int moveWhenLastIdx(final int userIdx) {
        final int leftSideIdx = userIdx - 1;
        if (points.get(leftSideIdx)) {
            return userIdx - 1;
        }

        return userIdx;
    }

    private int moveWhenFirstIdx(final int userIdx) {
        final int rightSideIdx = userIdx;
        if (points.get(rightSideIdx)) {
            return userIdx + 1;
        }

        return userIdx;
    }
}
