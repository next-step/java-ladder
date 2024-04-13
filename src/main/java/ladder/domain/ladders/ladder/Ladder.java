package ladder.domain.ladders.ladder;

import ladder.domain.ladders.PointPredicate;
import ladder.domain.ladders.factory.LineFactory;
import ladder.domain.participants.Position;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int countOfPerson, PointPredicate predicate) {
        this(LineFactory.generateLines(height, countOfPerson, predicate));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Position move(Position position) {
        return lines.stream()
                .reduce(position, (p, line) ->line.move(p), (p1, p2) -> p2);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
