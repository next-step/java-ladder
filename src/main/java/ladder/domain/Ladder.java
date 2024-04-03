package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> lines;

    public Ladder(int ladderHeight, int countOfPerson) {
        this.lines = Stream.generate(() -> new Line(countOfPerson))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lines.stream().map(Line::toString).collect(Collectors.joining("\n"));
    }
}
