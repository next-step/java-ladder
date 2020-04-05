package ladder.domain;

import java.util.*;

public class Line {
    private static final int START_LINE_POSITION = 0;

    private List<Boolean> line;

    public Line(int playerCount) {
        List<Boolean> lines = new ArrayList<>(playerCount);
        for (int i = 0; i < playerCount; i++) {
            lines.add(checkExistLine(i));
        }
        this.line = Collections.unmodifiableList(lines);
    }

    public List<Boolean> getLine() {
        return line;
    }

    private Boolean checkExistLine(final int count) {
        return !isStart(count);
    }

    private boolean isStart(final int count) {
        return count == START_LINE_POSITION;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}
