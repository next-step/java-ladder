package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int height, int personCount) {
        this(makeLines(height, personCount));
    }

    private static List<Line> makeLines(int height, int personCount) {
        List<Line> newLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            newLines.add(new Line(personCount));
        }
        return newLines;
    }

    public List<Line> lines() {
        return lines;
    }
}
