package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private final int numberOfPlayer;
    private final List<Boolean> points;

    private Line(final int numberOfPlayer, final List<Boolean> points) {
        this.numberOfPlayer = numberOfPlayer;
        this.points = Collections.unmodifiableList(points);
    }

    public static Line of(final int numberOfPlayer) {
        List<Boolean> points = new ArrayList<>(numberOfPlayer);
        // todo generate via strategy
        Collections.fill(points, false);

        return new Line(numberOfPlayer, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return numberOfPlayer == line.numberOfPlayer && Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPlayer, points);
    }
}
