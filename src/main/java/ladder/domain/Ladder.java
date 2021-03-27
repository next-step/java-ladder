package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int POINT_START_INDEX = 0;
    private List<Line> lines;

    public Ladder(int ladderSize, int countOfPerson) {
        this.lines = createLadder(ladderSize, countOfPerson);
    }

    private List<Line> createLadder(int ladderSize, int countOfPerson) {
        return IntStream.range(POINT_START_INDEX, ladderSize)
                .mapToObj(index -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<Line> readOnlyLines() {
        return Collections.unmodifiableList(lines);
    }
}
