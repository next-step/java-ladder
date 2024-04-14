package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;
    private final static String INVALID_EMPTY_MESSAGE = "빈 List<Point>를 통해 Line을 생성할 수 없습니다.";
    private final static String INVALID_CONNECT_MESSAGE = "연속된 연결을 될 수 없습니다.";

    public Line(List<Point> points) {
        checkInvalidPoints(points);
        this.points = points;
    }

    public Line(boolean... pointsStatus) {
        this(connectedStatus(pointsStatus));
    }

    private void checkInvalidPoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(INVALID_EMPTY_MESSAGE);
        }

        if (isInvalidConnect(points)) {
            throw new IllegalArgumentException(INVALID_CONNECT_MESSAGE);
        }
    }

    private static boolean isInvalidConnect(List<Point> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(i -> points.get(i).isConnect() && points.get(i + 1).isConnect());
    }

    private static List<Point> connectedStatus(boolean[] pointsStatus) {
        return IntStream.range(0, pointsStatus.length)
                .mapToObj(i -> new Point(pointsStatus[i]))
                .collect(Collectors.toList());
    }

    public List<Point> connectedStatus() {
        return Collections.unmodifiableList(points);
    }

    public int getLength() {
        return points.size();
    }
}
