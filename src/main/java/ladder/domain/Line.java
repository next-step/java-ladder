package ladder.domain;

import java.util.*;

public class Line {
    private static final int START_LINE_POSITION = 0;

    private List<Boolean> lines = new ArrayList<>();

    public Line(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            lines.add(checkExistLine(i));
        }
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Boolean> getLine() {
        return lines;
    }

    private Boolean checkExistLine(final int count) {
        if (isStart(count) || isExistPrev(count)) {
            return Boolean.FALSE;
        }
        return new Random().nextBoolean();
    }

    private boolean isStart(final int count) {
        return count == START_LINE_POSITION;
    }

    private Boolean isExistPrev(final int count) {
        return lines.get(count - 1);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Line line1 = (Line) o;
        return Objects.equals(lines, line1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
