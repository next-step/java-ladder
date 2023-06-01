package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Boolean> initializedPoints, int ladderHeight) {
        this.lines = Stream.generate(() -> new Line(initializedPoints))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
