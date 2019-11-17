package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private List<LineOfLadder> ladder;
    private List<Integer> finalPoints;

    public Ladder(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        verityLadderHeight(ladderHeight);
        addLine(personCount, ladderHeight, connectionStrategy);
    }

    private void addLine(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        List<LineOfLadder> lines = new ArrayList<>();
        List<Integer> points = null;
        for (int i = 0; i < ladderHeight; i++) {
            LineOfLadder line = new LineOfLadder(personCount - 1, connectionStrategy, points);
            lines.add(line);
            points = line.getPointsAfterConnection();
        }
        this.ladder = lines;
        this.finalPoints = points;
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

    public int getLadderSize() {
        return ladder.size();
    }
}
