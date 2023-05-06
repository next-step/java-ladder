package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int personCount, int ladderHeight) {
        this(createLines(personCount, ladderHeight));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> createLines(int personCount, int ladderHeight) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(personCount));
        }
        return ladder;
    }

    public List<Line> getLines() {
        return lines;
    }
}
