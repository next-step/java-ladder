package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(LadderConfig ladderConfig) {
        IntStream.range(0, ladderConfig.height())
            .mapToObj(i -> Line.newLine(ladderConfig.booleans()))
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
