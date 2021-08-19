package nextstep.ladders.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(final int countOfPerson, final int height) {
        RandomPointGenerateStrategy strategy = new RandomPointGenerateStrategy();
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson, strategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
