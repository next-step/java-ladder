package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(LadderSize ladderSize, ConnectionStrategy connectionStrategy) {
        List<Line> lines = IntStream.range(0, ladderSize.height())
                .mapToObj(i -> Line.generate(ladderSize.width(), connectionStrategy))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int index) {
        for (Line line : lines) {
            index = moveOneLine(index, line);
        }
        return index;
    }

    private int moveOneLine(int index, Line line) {
        if (canMoveLeft(index, line)) {
            return index - 1;
        }

        if (canMoveRight(index, line)) {
            return index + 1;
        }

        return index;
    }

    private boolean canMoveLeft(int index, Line line) {
        return index > 0 && line.isConnected(index - 1);
    }

    private boolean canMoveRight(int index, Line line) {
        return index < line.width() && line.isConnected(index);
    }
}
