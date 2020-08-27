package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int ladderHeight, Participants participant, LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            Line line = Line.create(participant, lineGenerator);
            lines.add(line);
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

}
