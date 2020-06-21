package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(LadderGenerator ladderGenerator) {
        this.lines = ladderGenerator.generate();
    }

    public int getGameResult(int x) {
        int result = x;
        for (Line line : lines) {
            result += line.getDirection(result).getValue();
        }
        return result;
    }

    public List<Line> getLines() {
        return lines;
    }
}
