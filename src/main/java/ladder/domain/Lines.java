package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Row> lines;

    public Lines(List<Row> lines) {
        this.lines = lines;
    }

    public static Lines create(int countOfPerson, int height) {
        return Stream.iterate(0, i -> i < height, i -> i + 1)
                .map(i -> Row.create(countOfPerson))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lines::new));
    }

    public List<Row> lines() {
        return Collections.unmodifiableList(this.lines);
    }
}