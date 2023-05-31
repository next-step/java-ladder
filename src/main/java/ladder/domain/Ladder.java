package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int countOfPerson, int ladderHeight, MakePointsStrategy makePointsStrategy) {
        this.lines = Stream.generate(() -> new Line(countOfPerson, makePointsStrategy))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}
