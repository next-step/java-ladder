package nextstep.step3.domain;

import java.util.List;

public class Ladder {
    private List<Line> lines;
    private DirectionChecker directionChecker;

    public Ladder(List<Line> lines) {
        this.lines = lines;
        directionChecker = new DirectionChecker(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Integer> getLadderGameResult() {
        return directionChecker.getResult();
    }
}
