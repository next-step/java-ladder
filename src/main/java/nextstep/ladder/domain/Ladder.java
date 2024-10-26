package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.domain.Line.createLines;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }

    public static Ladder createLadder(int height, int countOfPeople) {
        return new Ladder(createLines(height, countOfPeople - 1));
    }
}
