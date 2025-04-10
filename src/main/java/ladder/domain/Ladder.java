package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfUser) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfUser))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
