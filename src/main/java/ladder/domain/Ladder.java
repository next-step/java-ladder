package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = valid(lines);
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(int height, int width) {
        return of(IntStream.range(0, height)
            .mapToObj(i -> Line.of(width + 1))
            .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public int height() {
        return lines.size();
    }

    public int width() {
        return lines.get(0).length();
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }

    private List<Line> valid(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리는 빈 값일 수 없습니다.");
        }
        return lines;
    }

}
