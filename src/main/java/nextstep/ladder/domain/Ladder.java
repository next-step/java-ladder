package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPerson, Line... lines) {
        return of(height, countOfPerson, Arrays.asList(lines));
    }

    public static Ladder of(int height, int countOfPerson, List<Line> lines) {
        validateHeight(height, lines);
        validateSize(countOfPerson, lines);
        return new Ladder(lines);
    }

    private static void validateHeight(int height, List<Line> lines) {
        if (lines.size() != height) {
            throw new IllegalArgumentException("사다리 높이와 일치하지 않습니다.");
        }
    }

    private static void validateSize(int countOfPerosn, List<Line> lines) {
        Optional<Line> maybeLine = lines.stream()
                .filter(line -> !line.isSameSize(countOfPerosn - 1))
                .findAny();
        if (maybeLine.isPresent()) {
            throw new IllegalArgumentException("Point 개수가 올바르지 않습니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return lines.equals(ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
