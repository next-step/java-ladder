package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> lines;

    public Lines(int countOfPerson, int height) {
        this.lines = Stream.iterate(0, i -> i < height, i -> i + 1)
                .map(i -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(this.lines);
    }
}
