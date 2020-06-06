package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private static final int MINIMUM_PLAYER_COUNTS = 1;
    private static final int POINTS_CHUNK_SIZE = 5;
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line drawLine(int playerCounts) {
        validatePlayerCounts(playerCounts);
        List<Point> points = drawPoints(playerCounts);
        return new Line(points);
    }

    private static List<Point> drawPoints(int playerCounts) {
        return Stream.generate(() -> new Point(true))
                .limit((playerCounts - MINIMUM_PLAYER_COUNTS) * POINTS_CHUNK_SIZE)
                .collect(Collectors.toList());
    }

    private static void validatePlayerCounts(int playerCounts) {
        if (playerCounts < MINIMUM_PLAYER_COUNTS) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PLAYER_COUNTS);
        }
    }

    public int getLineSize() {
        return points.size();
    }
}
