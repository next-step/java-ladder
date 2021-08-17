package nextstep.ladders.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(int countOfPerson, int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
