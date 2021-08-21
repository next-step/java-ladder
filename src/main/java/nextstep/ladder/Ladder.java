package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladderLines;

    private Ladder(List<Line> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder of(int countOfPerson, int heightOfLadder) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            lines.add(Line.of(countOfPerson));
        }
        return new Ladder(lines);
    }

    public List<Line> getLadderLines() {
        return ladderLines;
    }
}
