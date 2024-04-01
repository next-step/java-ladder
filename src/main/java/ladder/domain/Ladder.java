package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        this(generateLines(height, countOfPerson));
    }

    private static List<Line> generateLines(int height, int countOfPerson) {
        return Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Position move(Position position) {
        return lines.stream()
                .reduce(position, (p, line) -> p.move(line::canMove), (p1, p2) -> p2);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
