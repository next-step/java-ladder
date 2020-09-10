package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Participants participants, Height height) {
        List<Line> lines = Stream.generate(() -> Line.of(participants))
                .limit(height.getValue())
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int postion) {
        for (Line line : lines) {
            postion = line.move(postion);
        }
        return postion;
    }
}
