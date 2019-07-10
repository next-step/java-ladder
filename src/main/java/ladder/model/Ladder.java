package ladder.model;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public final class Ladder {
    public static Ladder generateRandom(int height, int numberOfParticipants) {
        final List<Line> lines = IntStream.range(0, height)
                                          .mapToObj(i -> Line.generateRandom(numberOfParticipants))
                                          .collect(toList());
        return new Ladder(lines);
    }

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int start) {
        int end = start;
        for (Line line : lines) {
            end = line.move(end);
        }
        return end;
    }
}
