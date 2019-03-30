package ladder.domain.ladder;

import ladder.domain.enums.Complexity;
import ladder.domain.enums.Direction;
import ladder.domain.result.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public int generate(Complexity difficulty, int column) {
        IntStream.range(0, difficulty.height())
            .mapToObj(i -> Line.generate(difficulty, column))
            .forEach(this.lines::add);

        return difficulty.height();
    }

    public void move(Position position) {
        this.lines.forEach(line -> {
            Direction direction = position.getDirection(line);
            direction.move(position);
        });
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
