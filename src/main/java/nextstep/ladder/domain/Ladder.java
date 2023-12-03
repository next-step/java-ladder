package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line> {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    public Ladder(Players players, Height height, LineStrategy lineStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.height(); i++) {
            lines.add(createLine(players.size(), lineStrategy));
        }

        this.lines = lines;
    }

    private static Line createLine(int personCount, LineStrategy lineStrategy) {
        return lineStrategy.createLine(personCount);
    }

    public void validate(List<Line> lines) {
        checkLinesSizeIsValid(lines);
    }

    public void checkLinesSizeIsValid(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상이어야 합니다.");
        }
    }

    public int height() {
        return this.lines.size();
    }

    public Line startLine() {
        return this.lines.get(0);
    }

    public int movingResult(Line line, int pointIndex, int ladderHeight) {
        if (ladderHeight - 1 == this.height()) {
            return pointIndex;
        }

        Direction direction = direction(line, pointIndex, ladderHeight);
        if (direction == Direction.DOWN) {
            return movingResult(downPoint(ladderHeight), pointIndex, ladderHeight + 1);
        }

        if (direction == Direction.LEFT) {
            return movingResult(downPoint(ladderHeight), leftPointIndex(pointIndex), ladderHeight + 1);
        }

        if (direction == Direction.RIGHT) {
            return movingResult(downPoint(ladderHeight), rightPointIndex(pointIndex), ladderHeight + 1);
        }

        return 0;
    }

    private Direction direction(Line line, int pointIndex, int ladderHeight) {
        int firstIndex = 0;
        int lastIndex = line.points().size();
        Point point = null;
        Direction direction = null;

        if (pointIndex == firstIndex) {
            point = line.points().get(pointIndex);
            direction = point.compareMove(new Point(false), true, false);
        }

        if (pointIndex == lastIndex) {
            point = new Point(false);
            direction = point.compareMove(leftPoint(pointIndex, ladderHeight), false, true);
        }

        if (pointIndex != firstIndex && pointIndex != lastIndex) {
            point = line.points().get(pointIndex);
            direction = point.compareMove(leftPoint(pointIndex, ladderHeight), false, false);
        }

        return direction;
    }

    private Line downPoint(int ladderHeight) {
        if(ladderHeight == this.lines.size()) {
            return lines.get(ladderHeight - 1);
        }

        return lines.get(ladderHeight);
    }

    private Point leftPoint(int pointIndex, int ladderHeight) {
        return downPoint(leftPointIndex(ladderHeight)).points().get(leftPointIndex(pointIndex));
    }

    private static int leftPointIndex(int pointIndex) {
        return pointIndex - 1;
    }

    private static int rightPointIndex(int pointIndex) {
        return pointIndex + 1;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

    @Override
    public Iterator<Line> iterator() {
        return this.lines.iterator();
    }
}
