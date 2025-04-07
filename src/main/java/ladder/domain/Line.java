package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> line;

    public Line(int width, LineGenerator generator) {
        this(createLine(width, generator));
    }

    public Line(boolean... line) {
        this(boxed(line));
    }

    public Line(List<Boolean> line) {
        this.line = line;
    }

    private static List<Boolean> boxed(boolean[] line) {
        return IntStream.range(0, line.length)
                .mapToObj(i -> line[i])
                .collect(Collectors.toList());
    }

    private static List<Boolean> createLine(int width, LineGenerator generator) {
        List<Boolean> lines = IntStream.range(0, width)
                .mapToObj(i -> generator.isConnected())
                .collect(Collectors.toList());

        for (int i = 1; i < width; i++) {
            if (lines.get(i - 1) && lines.get(i)) {
                lines.set(i, false);
            }
        }
        return lines;
    }

    public List<Boolean> getList() {
        return Collections.unmodifiableList(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(line);
    }
}
