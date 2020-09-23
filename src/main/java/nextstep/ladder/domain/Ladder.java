package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    protected Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPersons, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPersons))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

    public List<Line> getLines() {
        return lines;
    }
}
