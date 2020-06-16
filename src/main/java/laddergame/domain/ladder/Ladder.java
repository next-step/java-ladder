package laddergame.domain.ladder;

import laddergame.domain.vo.Height;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height ladderHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        this.lines = createLines(ladderHeight.getHeight(), numberOfPlayer, connectGenerator);
    }

    private List<Line> createLines(int ladderHeight, int numberOfPlayer, BridgeConnectGenerator connectGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(numberOfPlayer, connectGenerator));
        }

        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
