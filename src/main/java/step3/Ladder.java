package step3;

import step3.util.SidelineGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder implements Iterable<Line> {
    private final List<Line> lines;

    public Ladder(int height, SidelineGenerator sidelineGenerator) {
        this.lines = createLines(height, sidelineGenerator);
    }

    private List<Line> createLines(int height, SidelineGenerator sidelineGenerator) {
        return Stream.generate(() -> new Line(sidelineGenerator))
                .limit(height)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
