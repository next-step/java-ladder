package nextstep.ladder.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int LADDER_MIN_COUNT = 2;
    private List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public void createLadder(int playerCount, int height) {
        if (height < LADDER_MIN_COUNT) {
            throw new IllegalArgumentException("사다리 높이는 최소 " + LADDER_MIN_COUNT + "가 되어야 합니다.");
        }
        for (int i=0; i<height; i++) {
            Line line = new Line();
            lines.add(line.createLine(playerCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
