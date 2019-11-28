package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.result.Points;

import java.util.ArrayList;
import java.util.Collections;
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
        for (int i = 0; i < ladderHeight; i++) {
            addLine(personCount, connectionStrategy);
        }
    }

    private void addLine(int personCount, ConnectionStrategy connectionStrategy) {
        LineOfLadder line = new LineOfLadder(personCount - 1, connectionStrategy);
        lines.add(line);
    }

    public Points getFinalPoints() {
        Points points = null;
        for (LineOfLadder lineOfLadder : lines) {
            points = lineOfLadder.movePoints(points);
        }
        return points;
    }

    private void verityLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
    }

    public LineOfLadder getByIndex(int index) {
        return lines.get(index);
    }

    public List<LineOfLadder> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}