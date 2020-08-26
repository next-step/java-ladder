package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int ladderHeight, LineRandomGenerator lineRandomGenerator) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            Line line = lineRandomGenerator.create();
            lines.add(line);
        }
        return new Ladder(lines);
    }

    public Stream<Line> stream() {
        return null;
    }

}
