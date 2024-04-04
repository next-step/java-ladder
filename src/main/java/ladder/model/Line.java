package ladder.model;

import java.util.List;
import java.util.stream.IntStream;

public class Line {
    public static final String INVALID_LINE = "사다리의 연달은 라인이 겹칠 수는 없습니다.";
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(List<Boolean> points) {
        if (isImpossibleLine(points)) {
            throw new IllegalArgumentException(INVALID_LINE);
        }

        return new Line(points);
    }

    private static boolean isImpossibleLine(List<Boolean> points) {
        return IntStream.range(1, points.size())
                .anyMatch(i -> points.get(i - 1) && points.get(i));
    }

    public int getSizeOfLine() {
        return points.size();
    }

    public boolean isConnectedLadder(int index) {
        return points.get(index);
    }
}
