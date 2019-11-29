package ladder.structure;

import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.result.Points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private final List<LineOfLadder> lines;

    public Lines(int participantsSize, int ladderHeight, MoveStrategy moveStrategy) {
        verifyLadderHeight(ladderHeight);
        this.lines = addLines(participantsSize, ladderHeight, moveStrategy);
    }

    private List<LineOfLadder> addLines(int participantsSize, int ladderHeight, MoveStrategy moveStrategy) {
        List<LineOfLadder> lines = new ArrayList<>();
        LineOfLadder line = new LineOfLadder(participantsSize, moveStrategy);
        lines.add(line);
        for (int i = 1; i < ladderHeight; i++) {
            line = line.getNext(moveStrategy);
            lines.add(line);
        }
        return Collections.unmodifiableList(lines);
    }

    public Points getFinalPoints(MoveStrategy moveStrategy) {
        return lines.get(lines.size() - 1).getPoints().getNext(moveStrategy);
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