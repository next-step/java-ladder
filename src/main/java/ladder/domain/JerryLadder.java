package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.domain.JerryLadderCreator.MIN_HEIGHT;

public class JerryLadder implements Ladder {
    private final List<Line> lines;

    public JerryLadder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLastPosition(int position) {
        return lines.stream()
                .reduce(position, (x, line) -> line.getNextPosition(x), (x, y) -> y);
    }
}
