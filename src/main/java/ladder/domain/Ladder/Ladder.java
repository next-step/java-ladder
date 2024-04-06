package ladder.domain.Ladder;

import ladder.domain.Ladder.factory.LadderFactory;
import ladder.domain.participants.Position;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        this(LadderFactory.generateLines(height, countOfPerson));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public Position move(Position position) {
        return lines.stream()
                .reduce(position, (p, line) -> p.move(line::canMove), (p1, p2) -> p2);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
