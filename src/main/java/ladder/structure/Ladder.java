package ladder.structure;

import ladder.structure.connection.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final String LADDER_HEIGHT_EXCEPTION = "사다리게임의 높이는 0 이상입니다.";
    private final List<LineOfLadder> lines;

    public Ladder(int participantsSize, int ladderHeight, MoveStrategy moveStrategy) {
        verifyLadderHeight(ladderHeight);
        this.lines = addLine(participantsSize, ladderHeight, moveStrategy);
    }

    private List<LineOfLadder> addLine(int participantsSize, int ladderHeight, MoveStrategy moveStrategy) {
        List<LineOfLadder> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new LineOfLadder(participantsSize, moveStrategy));
        }
        return Collections.unmodifiableList(lines);
    }

    public List<Integer> getFinalPoints() {
        List<Integer> games = null;
        for (LineOfLadder line : lines) {
            games = line.getNext(games);
        }
        return games;
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