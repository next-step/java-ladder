package ladder.model;

import ladder.generator.BooleanGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfUser, int ladderHeight, BooleanGenerator booleanGenerator) {
        List<Line> lines = IntStream.range(0, ladderHeight)
                .mapToObj(size -> Line.of(countOfUser, booleanGenerator))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int height() {
        return this.lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
