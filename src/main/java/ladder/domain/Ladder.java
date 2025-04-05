package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, People people, ConnectStrategy connectStrategy) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(people.size(), connectStrategy))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
