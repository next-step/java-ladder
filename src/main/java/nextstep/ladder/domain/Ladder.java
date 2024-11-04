package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int move(int position) {
        for (int row = 0; row < lines.size(); row++) {
            Line line = lines.get(row);
            position = line.move(position);
        }
        return position;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Line line : lines) {
            builder.append(line.toString());
        }
        return builder.toString();
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
}
