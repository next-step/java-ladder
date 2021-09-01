package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        validateNotConnectedInSeries(points);
        this.points = Collections.unmodifiableList(points);
    }

    private void validateNotConnectedInSeries(List<Boolean> points) {
        points.stream()
                .reduce(this::validateNotConnectedInSeries);
    }

    private boolean validateNotConnectedInSeries(boolean firstPointConnected, boolean secondPointConnected) {
        if (firstPointConnected && secondPointConnected) {
            throw new IllegalArgumentException("연속으로 연결된 포인트가 존재합니다.");
        }
        return secondPointConnected;
    }

    public static Line of(LineConnectStrategy lineConnectStrategy) {
        return new Line(lineConnectStrategy.getLineConnections());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
