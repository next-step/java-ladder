package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfPeople) {
        lines = new ArrayList<>();

        IntStream.range(0, height)
                .forEach(num -> lines.add(new Line(countOfPeople)));
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
