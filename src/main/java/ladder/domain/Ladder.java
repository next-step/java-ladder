package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private static final String EMPTY_LADDER_EXCEPTION_MESSAGE = "사다리는 Line이 1개 이상 있어야 합니다";

    private final Lines lines;
    private final List<String> results;

    private Ladder(List<Line> lines, List<String> results) {
        this(Lines.from(lines), results);
    }

    private Ladder(Lines lines, List<String> results) {
        this.lines = lines;
        this.results = results;
    }

    public static Ladder from(List<Line> lines, List<String> results) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LADDER_EXCEPTION_MESSAGE);
        }
        return new Ladder(lines, results);
    }

    public List<Line> lines() {
        return lines.value();
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

    @Override
    public String toString() {
        return "Ladder{" +
            "lines=" + lines +
            '}';
    }
}
