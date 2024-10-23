package ladder.domain;

import ladder.generator.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final PositiveNumber height;
    private final List<Line> lines;

    public Ladder(PositiveNumber height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public static Ladder of(int weight, int height, Strategy strategy) {
        return new Ladder(new PositiveNumber(height), createLines(weight, height, strategy));
    }

    private static List<Line> createLines(int weight, int height, Strategy strategy) {
        return IntStream.range(0, height)
                .mapToObj(n -> new Line(weight, strategy))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(height, ladder.height) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, lines);
    }

}
