package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        validateNotConnectedInSeries(points);
        this.points = Collections.unmodifiableList(points);
    }

    private void validateNotConnectedInSeries(List<Point> points) {
        points.stream()
                .reduce(this::validateNotConnectedInSeries);
    }

    private Point validateNotConnectedInSeries(Point firstPointConnected, Point secondPointConnected) {
        if (firstPointConnected.isConnected() && secondPointConnected.isConnected()) {
            throw new IllegalArgumentException("연속으로 연결된 포인트가 존재합니다.");
        }
        return secondPointConnected;
    }

    public static Line of(LineConnectStrategy lineConnectStrategy) {
        return new Line(lineConnectStrategy.getLineConnections());
    }

    public List<Point> getPoints() {
        return points;
    }
}
