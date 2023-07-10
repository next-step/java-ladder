package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.domain.JerryLadderCreator.MIN_HEIGHT;

public class JerryLadder implements Ladder {
//    public static final int MIN_HEIGHT = 1;
    private final List<Line> lines;

    public JerryLadder(List<Line> lines) {
        validateHeight(lines.size());

        this.lines = lines;
    }

    public static JerryLadder of(int width, int height) {
        validateHeight(height);

        return new JerryLadder(Stream.generate(() -> JerryLine.createLineWithWidth(width))
                .limit(height)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public static JerryLadder of(List<Line> lines) {
        return new JerryLadder(lines);
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLastPosition(int position) {
        return lines.stream()
                .reduce(position, (x, line) -> line.getNextPosition(x), (x, y) -> y);
    }
}
