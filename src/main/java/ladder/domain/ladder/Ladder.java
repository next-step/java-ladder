package ladder.domain.ladder;

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

    public int generate(int low, int column) {
        IntStream.range(0, low)
            .mapToObj(i -> Line.generate(column))
            .forEach(this.lines::add);

        return low;
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
