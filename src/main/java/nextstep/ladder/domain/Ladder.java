package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Ladder(int height, int countOfPerson, Connector connector) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(Line.of(countOfPerson, connector));
        }
    }

    public static Ladder ofHeightAndCountOfPerson(int height, int countOfPerson, Connector connector) {
        return new Ladder(height, countOfPerson, connector);
    }

    public Position move(Position position) {
        for (Line line : lines) {
            position = position.move(line);
        }
        return position;
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

    public List<Line> getLadder() {
        return Collections.unmodifiableList(lines);
    }
}
