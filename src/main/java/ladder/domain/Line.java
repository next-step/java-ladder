package ladder.domain;

import java.util.*;

public class Line {
    private final List<Boolean> lines;

    private Line(final List<Boolean> lines) {
        this.lines = lines;
    }

    public static Line of(int playerCount) {
        return new Line(LineGenerateHelper.generate(playerCount));
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(lines);
    }

    public int move(final int playerStartPosition) {
        return 0;
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
