package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private static final String CONNECTED_IN_SERIES_EXCEPTION_MESSAGE = "연속으로 연결된 포인트가 존재합니다.";
    private static final String INVALID_POINTS_COUNT_EXCEPTION_MESSAGE_FORMAT = "포인트의 개수가 유효하지 않습니다. points: %s, countOfPlayer: %s";
    private static final int COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS = 1;

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
        List<Boolean> points = lineConnectStrategy.getLineConnections(countOfPlayer);
        validatePointsSize(points, countOfPlayer);
        return new Line(points);
    }

    private static void validatePointsSize(List<Boolean> points, int countOfPlayer) {
        if (points.size() != countOfPlayer - COUNT_GAP_BETWEEN_POINTS_AND_PLAYERS) {
            throw new IllegalArgumentException(String.format(INVALID_POINTS_COUNT_EXCEPTION_MESSAGE_FORMAT, points, countOfPlayer));
        }
    }
}
