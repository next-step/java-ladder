package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import laddergame.domain.line.ConnectionStrategy;
import laddergame.domain.line.Line;
import laddergame.domain.person.Participants;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(ConnectionStrategy connectionStrategy, Depth depth, Participants participants) {
        List<Line> lines = new ArrayList<>(depth.size());
        IntStream.range(0, depth.size())
            .forEach(e -> lines.add(new Line(participants.size(), connectionStrategy)));
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
