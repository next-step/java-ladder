package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int personCount, Conditional conditional) {
        IntStream.range(0, height)
                .forEach(idx -> ladder.add(new Line(personCount, conditional)));
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
