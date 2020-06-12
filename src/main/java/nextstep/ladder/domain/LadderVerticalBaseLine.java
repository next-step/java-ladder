package nextstep.ladder.domain;

public class LadderVerticalBaseLine {
    private final LadderGameUser ladderGameUser;
    private final ConnectPoints connectPoints;

    public LadderVerticalBaseLine(LadderGameUser userName, ConnectPoints connectPoints) {
        this.ladderGameUser = userName;
        this.connectPoints = connectPoints;
    }

    public boolean connectedWith(final Point point) {
        return connectPoints.has(point);
    }

    public ConnectPoints getConnectPoints() {
        return new ConnectPoints(connectPoints);
    }

    public LadderGameUser getLadderGameUser() {
        return ladderGameUser;
    }
}
