package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import ladder.domain.Position;
import ladder.domain.line.Line;
import ladder.domain.user.User;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Position playGame(User user) {
        Position newPosition = user.getStartPosition();
        for (Line line : lines) {
            newPosition = line.getNextLinePosition(newPosition);
        }
        return newPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
