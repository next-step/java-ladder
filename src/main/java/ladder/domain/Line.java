package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int MINIMUM_PLAYER_COUNTS = 1;

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line drawLine(int playerCounts) {
        validatePlayerCounts(playerCounts);
        List<Point> points = drawLineWithStrategy(playerCounts, new RandomDrawingLineStrategy());
        return new Line(points);
    }

    private static void validatePlayerCounts(int playerCounts) {
        if (playerCounts < MINIMUM_PLAYER_COUNTS) {
            throw new LadderBuildingException(LadderBuildingException.INVALID_PLAYER_COUNTS);
        }
    }

    private static List<Point> drawLineWithStrategy(int playerCounts,
                                                    DrawingLineStrategy drawingLineStrategy) {
        return drawingLineStrategy.drawLine(playerCounts);
    }

    public List<Boolean> getPointPositions() {
        return points.stream()
                .map(Point::getIsExisting)
                .collect(Collectors.toList());
    }
}
