package nextstep.ladder.domain;

public class BaseUserLine {
    private final LadderGameUser ladderGameUser;
    private final ConnectPoints connectPoints;

    public BaseUserLine(LadderGameUser userName, ConnectPoints connectPoints) {
        this.ladderGameUser = userName;
        this.connectPoints = connectPoints;
    }

    public boolean isConnected(final Point point) {
        return connectPoints.hasPoint(point);
    }

    public ConnectPoints getConnectPoints() {
        return new ConnectPoints(connectPoints);
    }

    public LadderGameUser getLadderGameUser() {
        return ladderGameUser;
    }
}
