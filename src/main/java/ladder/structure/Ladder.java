package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private List<LineOfLadder> ladder;
    private List<Integer> finalPoints;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        this.ladder = new ArrayList<>();
        verityLadderHeight(ladderHeight);
        addLines(personCount, ladderHeight, connectionStrategy);
    }

    private void addLines(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        List<Integer> points = null;
        for (int i = 0; i < ladderHeight; i++) {
            points = addLine(personCount, connectionStrategy, points);
        }
        this.finalPoints = points;
    }

    private List<Integer> addLine(int personCount, ConnectionStrategy connectionStrategy, List<Integer> points) {
        LineOfLadder line = new LineOfLadder(personCount - 1, connectionStrategy, points);
        ladder.add(line);
        return line.getPointsAfterConnection();
    }

    private void verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
    }

    public int getFinalPoint(int index) {
        return finalPoints.get(index);
    }

    public LineOfLadder getLine(int index) {
        return ladder.get(index);
    }

    public int getLadderHeight() {
        return ladder.size();
    }

    public int getLadderWidth() {
        return finalPoints.size() - 1;
    }
}
