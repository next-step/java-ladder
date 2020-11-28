package step2.domain;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final List<LadderPoint> ladderPoints;

    private Line(List<LadderPoint> ladderPoints) {
        this.ladderPoints = ladderPoints;
    }

    public static Line of(final int personCount, LineStrategy lineStrategy) {
        return new Line(lineStrategy.createLine(personCount));
    }


    public List<LadderPoint> getLadderPoints() {
        return unmodifiableList(ladderPoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(ladderPoints, line.ladderPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderPoints);
    }
}
