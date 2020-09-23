package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lines {

    private List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int countOfPerson, Line... lines) {
        return of(countOfPerson, Arrays.asList(lines));
    }

    public static Lines of(int countOfPerson, List<Line> lines) {
        validateSize(countOfPerson, lines);
        return new Lines(lines);
    }

    private static void validateSize(int countOfPerson, List<Line> lines) {
        lines.stream()
                .forEach(line -> line.checkCountOfPoints(countOfPerson - 1));
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return lines.equals(lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
