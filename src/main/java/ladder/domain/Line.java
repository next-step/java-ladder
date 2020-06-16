package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line drawLine(int playerCounts, DrawingLineStrategy drawingLineStrategy) {
        validatePlayerCounts(playerCounts);
        List<Point> points = drawingLineStrategy.drawLine(playerCounts);
        return new Line(points);
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
