package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int points, LadderGenerateRule ladderGenerateRule) {
        List<Line> lines = new ArrayList<>();
        int stepCount = points - 1;

        for (int i = 0; i < height ; i++) {
            lines.add(new Line(stepCount, ladderGenerateRule));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
