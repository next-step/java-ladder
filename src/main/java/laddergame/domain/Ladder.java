package laddergame.domain;

import laddergame.util.ValueGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(Line... lines) {
        this(Arrays.asList(lines));
    }

    public static Ladder create(Height height, Width width, ValueGenerator valueGenerator) {
        List<Line> lines = new ArrayList<>();
        Count count = new Count(0);
        while (height.bigger(count)) {
            lines.add(Line.create(width, valueGenerator));
            count.plus();
        }
        return new Ladder(lines);
    }

    public List<Line> getRows() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "rows=" + lines +
                '}';
    }
}
