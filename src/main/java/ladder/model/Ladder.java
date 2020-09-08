package ladder.model;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPoints, LadderGenerateStrategy ladderGenerateStrategy) {
        Lines lines = new Lines(height, countOfPoints, ladderGenerateStrategy);
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines.getLines();
    }

    protected int rideLadder(int userPoint) {
        return lines.processLines(userPoint);
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
