package step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private List<Line> lines;

    public Lines() {}

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines lines(Height height, int personCount) {
        Lines lines = new Lines();
        Line line = new Line();

        lines.lines =
                Stream.generate(() -> line.generate(personCount))
                .limit(height.height())
                .collect(Collectors.toList());

        return lines;
    }

    public List<Line> lines() {
        return this.lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
