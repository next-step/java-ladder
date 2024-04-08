package nextstep.ladder.domain.lines.line.impl;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.ladderConnectOrder.LadderConnectOrder;
import nextstep.ladder.domain.lines.line.Line;
import nextstep.ladder.domain.lines.point.Point;
import nextstep.ladder.error.exception.LineNoConsecutiveTrues;

public class LineImpl implements Line {

    private final List<Point> points;

    public LineImpl(LadderConnectOrder randomLadderConnectOrder) {
        this(initializeLine(randomLadderConnectOrder));
    }

    public LineImpl(List<Point> points) {
        if (isConsecutiveTrues(points)) {
            throw new LineNoConsecutiveTrues();
        }
        this.points = points;
    }

    private static List<Point> initializeLine(LadderConnectOrder randomLadderConnectOrder) {
        return randomLadderConnectOrder.connectLadder();
    }


    private boolean isConsecutiveTrues(List<Point> points) {
        return IntStream.range(0, points.size() - 1)
            .anyMatch(
                pointIndex -> points.get(pointIndex).isPointTrue() && points.get(pointIndex + 1)
                    .isPointTrue());
    }

    @Override
    public boolean canMoveRight(int userIndex) {
        if (isValidUserIndexSize(userIndex) && isRightTrue(userIndex)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canMoveLeft(int userIndex) {
        if (isValidUserIndexPositive(userIndex) && isLeftTrue(userIndex)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public int size() {
        return points.size();
    }

    private boolean isValidUserIndexSize(int userIndex) {
        return userIndex < points.size();
    }

    private boolean isRightTrue(int userIndex) {
        return points.get(userIndex).isPointTrue();
    }

    private boolean isValidUserIndexPositive(int userIndex) {
        return userIndex > 0;
    }

    private boolean isLeftTrue(int userIndex) {
        return points.get(userIndex - 1).isPointTrue();
    }
}
