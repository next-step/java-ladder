package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> lines;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        lines = new ArrayList<>();

        for (int i = 0; i < numberOfUser - 1; i++) {
            if (i != 0 && lines.get(lines.size() - 1)) {
                lines.add(false);
                continue;
            }
            boolean drawLine = ladderStrategy.generateLine();
            lines.add(drawLine);
        }

    }

    public Line(List<Boolean> lines) {
        this.lines = lines;
    }

    public List<Boolean> getLine() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lines, line.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
