package ladder.structure;

import ladder.structure.connection.ConnectionStrategy;
import ladder.structure.connection.result.Points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private final List<LineOfLadder> lines;

    public Lines(int participantsSize, int ladderHeight, ConnectionStrategy connectionStrategy) {
        verifyLadderHeight(ladderHeight);
        this.lines = addLines(participantsSize, ladderHeight, connectionStrategy);
    }

    private List<LineOfLadder> addLines(int participantsSize, int ladderHeight, ConnectionStrategy connectionStrategy) {
        List<LineOfLadder> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new LineOfLadder(participantsSize, connectionStrategy));
        }
        return Collections.unmodifiableList(lines);
    }

    public Points getFinalPoints(ConnectionStrategy connectionStrategy) {
        Points points = null;
        for (LineOfLadder lineOfLadder : lines) {
            points = lineOfLadder.movePoints(connectionStrategy);
        }
        return points;
    }
    public Points getFinalPoints() {
        Points points = null;
        for (LineOfLadder lineOfLadder : lines) {
            points = lineOfLadder.movePoints();
        }
        return points;
    }

    private void verifyLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException(LADDER_HEIGHT_EXCEPTION);
        }
    }

    public List<LineOfLadder> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}