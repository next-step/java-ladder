package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Participants participants, Height height) {
        List<Line> lines = new ArrayList<>();

        while (!height.equals(lines.size())) {
            lines.add(Line.of(participants));
        }

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

}
