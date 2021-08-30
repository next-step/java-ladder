package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private static final String CONNECTED_IN_SERIES_EXCEPTION_MESSAGE = "연속으로 연결된 포인트가 존재합니다.";

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
            throw new IllegalArgumentException(CONNECTED_IN_SERIES_EXCEPTION_MESSAGE);
        }
        return secondPointConnected;
    }

    public static Line of(LineConnectStrategy lineConnectStrategy, int countOfPlayer) {
        return new Line(lineConnectStrategy.getLineConnections(countOfPlayer));
    }
}
