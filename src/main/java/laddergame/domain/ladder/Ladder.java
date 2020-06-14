package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final List<Line> lines;

    public Ladder(int ladderHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        validateLadderHeight(ladderHeight);
        this.lines = createLines(ladderHeight, numberOfPlayer, connectGenerator);
    }

    private List<Line> createLines(int ladderHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(numberOfPlayer, connectGenerator));
        }

        return lines;
    }

    public void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이가 너무 작습니다. - " + ladderHeight);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
