package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<Pipes> convertToPipes() {
        return lines.stream()
                .map(Line::convertToPipes)
                .collect(Collectors.toList());
    }

    public void move(Player player) {
        lines.stream()
                .forEach(player::move);
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
