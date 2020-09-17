package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Boolean> connections) {
        validateLine(connections);
        return new Line(mapToPoint(connections));
    }

    private static void validateLine(List<Boolean> connections) {
        boolean before = false;
        for (Boolean connection : connections) {
            before = checkDisconnected(before, connection);
        }
    }

    private static boolean checkDisconnected(boolean before, boolean after) {
        if (before && after) {
            throw new IllegalArgumentException("가로 라인은 겹칠 수 없습니다.");
        }
        return after;
    }

    private static List<Point> mapToPoint(List<Boolean> connections) {
        return connections.stream()
                .map(Point::of)
                .collect(Collectors.toList());
    }
}
