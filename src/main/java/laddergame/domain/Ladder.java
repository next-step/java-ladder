package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LineStrategy lineStrategy, Depth depth, Participants participants) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, depth.size())
            .forEach(e -> lines.add(new Line(participants.size(), lineStrategy)));
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int size() {
        return lines.size();
    }
}
