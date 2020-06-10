package nextstep.ladder.domain;

public class BaseUserLine {
    private final LadderGameUser userName;
    private final ConnectPoints connectPoints;

    public BaseUserLine(LadderGameUser userName, ConnectPoints connectPoints) {
        this.userName = userName;
        this.connectPoints = connectPoints;
    }

    public boolean isConnected(final Point point) {
        return connectPoints.hasPoint(point);
    }
}
