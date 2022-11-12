package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void run(Players players) {
        for (Line line : lines) {
            line.checkPointAndChangePosition(players);
        }
    }
}
