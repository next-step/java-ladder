package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int countOfPerson, int maxHeightOfLadder) {
        this.lines = IntStream.range(0, maxHeightOfLadder)
                .mapToObj(idx -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return new ArrayList<>(lines);
    }
}
