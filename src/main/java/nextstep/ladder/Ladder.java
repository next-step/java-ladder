package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int personCount, int ladderHeight) {
        this(createLines(personCount, ladderHeight));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> createLines(final int personCount, final int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                 .mapToObj(value -> new Line(personCount))
                 .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
