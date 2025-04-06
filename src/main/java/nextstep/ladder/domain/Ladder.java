package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int numberOfPeople, int height) {
        this.lines = IntStream.range(0, height)
            .mapToObj(i -> new Line(numberOfPeople))
            .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
