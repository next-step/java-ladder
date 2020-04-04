package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> line;

    public Line(int countOfPerson) {
        List<Boolean> lines = new ArrayList<>(countOfPerson);
        for (int i = Player.PLAYER_MIN_COUNT; i < countOfPerson; i++) {
            lines.add(true);
        }
        this.line = Collections.unmodifiableList(lines);
    }

    public List<Boolean> getLine() {
        return line;
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
