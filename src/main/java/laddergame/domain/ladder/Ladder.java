package laddergame.domain.ladder;

import laddergame.util.ValueGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Line... lines) {
        return new Ladder(Arrays.stream(lines)
                .collect(Collectors.toList()));
    }

    public static Ladder create(Size size, ValueGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size.height(); i++) {
            lines.add(Line.create(size.width(), generator));
        }
        return new Ladder(lines);
    }

    public int ride(int start) {
        int end = start;
        for (Line line : lines) {
            end = line.move(end);
        }
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
