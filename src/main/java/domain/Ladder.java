package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson - 1))
                .collect(Collectors.toList());
    }

    public void printline() {
        lines.forEach(Line::print);
    }
}
