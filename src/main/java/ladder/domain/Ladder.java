package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {

        IntStream.range(0, height)
            .forEach((index) -> ladder.add(new Line(countOfPerson)));
    }

    public List<Line> getLadder() {
        return this.ladder;
    }
}
