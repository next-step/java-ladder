package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static final String INPUT_HEIGHT_ERROR = "사다리의 높이는 최소 1개 이상이어야 합니다.";
    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(GameSetup gameSetup, DirectionRule directionRule) {
        return new Lines(IntStream.range(0, checkMinimumHeight(gameSetup.getHeight()))
                .mapToObj(i -> new Line(gameSetup.getCountOfPerson(), directionRule))
                .collect(Collectors.toList()));
    }

    private static int checkMinimumHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INPUT_HEIGHT_ERROR);
        }
        return height;
    }

    public int getFinalPosition(int position) {
        int current = position;
        for (Line line : lines) {
            current = line.movePoint(current);
        }
        return current;
    }

    public List<Line> getLines() {
        return lines;
    }
}
