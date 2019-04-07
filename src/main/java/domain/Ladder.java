package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int length, int height, BooleanGenerator booleanGenerator) {
        IntStream.range(0, height)
            .mapToObj(i -> new Line(booleanGenerator.generate(length)))
            .forEach(lines::add);
    }

    public Integer search(Integer location) {
        for (Line line : lines) {
            location = line.move(location);
        }

        return location;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return lines.stream()
            .map(Line::toString)
            .collect(Collectors.joining("\n"));
    }
}
