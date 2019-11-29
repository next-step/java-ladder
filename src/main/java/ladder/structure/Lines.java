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
        LineOfLadder line = new LineOfLadder(participantsSize, connectionStrategy);
        lines.add(line);
        for (int i = 0; i < ladderHeight; i++) {
            line = line.getNext(connectionStrategy);
            lines.add(line);
        }
        return Collections.unmodifiableList(lines);
    }

    public Points getFinalPoints(ConnectionStrategy connectionStrategy) {
        return lines.get(lines.size() - 1).getPoints();
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