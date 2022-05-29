package ladder.domain.ladder;

import ladder.domain.point.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final int INITIAL_HEIGHT = 0;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    private void validate(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("lines는 빈 값일 수 없습니다.");
        }
    }

    public Position trace(Position position) {
        Position movingPosition = position;
        for (Line line : lines) {
            movingPosition = line.trace(movingPosition);
        }
        return movingPosition;
    }

    public static Ladder generateByWidthAndHeight(int width, int height) {
        return new Ladder(
                IntStream.range(INITIAL_HEIGHT, height)
                        .mapToObj(i -> Line.init(width))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));

    }
}
