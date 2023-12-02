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

    public List<Line> lines() {
        return this.lines;
    }

    public int height() {
        return this.lines.size();
    }

    public Line startLine() {
        return this.lines.get(0);
    }

    public LadderGameResult play(Players players, Line startLine, Amounts amounts) {
        LadderGameResult ladderGameResult = new LadderGameResult();
        int pointIndex = 0;
        for (Player player : players) {
            int amountIndex = movingResult(startLine, pointIndex, 1);
            Amount amount = amounts.get(amountIndex);
            pointIndex++;
            ladderGameResult.put(player, amount);
        }

        return ladderGameResult;
    }

    private int movingResult(Line line, int pointIndex, int ladderHeight) {
        int firstIndex = 0;
        int lastIndex = lines.get(0).points().size();

        Point point = null;
        Direction direction = null;

        if (pointIndex == firstIndex) {
            point = line.points().get(pointIndex);
            direction = point.compareMove(null, true, false);
        }

        else if (pointIndex == lastIndex) {
            point = new Point(false);
            direction = point.compareMove(line.points().get(pointIndex - 1), false, true);
        }

        else if (pointIndex != firstIndex && pointIndex != lastIndex) {
            point = line.points().get(pointIndex);
            direction = point.compareMove(lines.get(ladderHeight - 1).points().get(pointIndex - 1), false, false);
        }

        if (direction == Direction.DOWN) {
            if(ladderHeight == this.height()) {
                return pointIndex;
            }
            return movingResult(lines.get(ladderHeight), pointIndex, ladderHeight + 1);
        }

        else if (direction == Direction.LEFT) {
            if (ladderHeight == this.height()) {
                return pointIndex - 1;
            }
            return movingResult(lines.get(ladderHeight), pointIndex - 1, ladderHeight + 1);
        }

        else if (direction == Direction.RIGHT) {
            if (ladderHeight == this.height()) {
                return pointIndex + 1;
            }
            return movingResult(lines.get(ladderHeight), pointIndex + 1, ladderHeight + 1);
        }

        return 0;
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
