package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine drawLine(int playerCounts, DrawingLineStrategy drawingLineStrategy) {
        validatePlayerCounts(playerCounts);
        List<Point> points = drawingLineStrategy.drawLine(playerCounts);
        return new LadderLine(points);
    }

    private static void validatePlayerCounts(int playerCounts) {
        if (playerCounts < PlayersGroup.MINIMUM_PLAYER_COUNTS) {
            throw new LadderBuildingException(LadderBuildingException.INVALID_PLAYER_COUNTS);
        }
    }

    public int movePointOnLine(int index) {
        Point point = points.get(index);
        return point.moveByDirection();
    }

    public List<Direction> getPointDirections() {
        return points.stream()
                .map(Point::getDirection)
                .collect(Collectors.toList());
    }
}
