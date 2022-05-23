package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인들이 존재하지 않습니다.");
        }
        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public Line movedFrom(Position position) {
        if (position.isOver(lines.size() - 1)) {
            throw new IllegalArgumentException("더 이상 이동할 수 없습니다.");
        }
        return lines.get(position.forward());
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
                "lines=" + lines +
                '}';
    }
}
