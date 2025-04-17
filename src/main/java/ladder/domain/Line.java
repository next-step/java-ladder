package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> line;

    public Line(int size, LineGenerator generator) {
        this(createLine(size, generator));
    }

    public Line(boolean... line) {
        this(createLine(line));
    }

    public Line(List<Boolean> line) {
        this.line = line;
    }

    private static List<Boolean> createLine(int size, LineGenerator generator) {
        if (size < 1) {
            throw new IllegalArgumentException("Line size should be greater than 0");
        }
        return createLine(generate(size, generator));
    }

    private static List<Boolean> createLine(boolean[] line) {
        return IntStream.range(0, line.length)
                .mapToObj(i -> line[i])
                .collect(Collectors.toList());
    }

    private static boolean[] generate(int size, LineGenerator generator) {
        boolean[] line = new boolean[size];
        line[0] = generator.isConnected();

        for (int i = 1; i < size; i++) {
            line[i] = (!line[i - 1] && generator.isConnected());
        }

        return line;
    }

    public List<Boolean> getList() {
        return Collections.unmodifiableList(line);
    }

    public boolean hasSameWidth(int width) {
        return line.size() == width;
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
