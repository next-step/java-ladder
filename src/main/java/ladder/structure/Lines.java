package ladder.structure;

import ladder.game.Points;
import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private List<LineOfLadder> lines;

    public Lines(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        verityLadderHeight(ladderHeight);
        this.lines = new ArrayList<>();
        addLines(personCount, ladderHeight, connectionStrategy);
    }

    private void addLines(int personCount, int ladderHeight, ConnectionStrategy connectionStrategy) {
        Points points = new Points(personCount - 1);
        for (int i = 0; i < ladderHeight; i++) {
            points = addLine(personCount, connectionStrategy, points);
        }
    }

    private Points addLine(int personCount, ConnectionStrategy connectionStrategy, Points points) {
        LineOfLadder line = new LineOfLadder(personCount - 1, connectionStrategy, points);
        lines.add(line);
        return line.getPointsAfterConnection();
    }

    public LineOfLadder getLine(int index) {
        return lines.get(index);
    }

    public int getLadderHeight() {
        return lines.size();
    }

    private void verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
    }

    public Points getFinalPoints() {
        return lines.get(lines.size() - 1).getPointsAfterConnection();
    }
}