package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int numberOfUsers, SidelineGenerator sidelineGenerator) {
        this.lines = createLines(numberOfUsers, height, sidelineGenerator);
    }

    private List<Line> createLines(int numberOfUsers, int height, SidelineGenerator sidelineGenerator) {
        return Stream.generate(() -> new Line(numberOfUsers, sidelineGenerator))
                .limit(height)
                .collect(Collectors.toList());
    }
}
