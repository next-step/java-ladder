package nextstep.ladder.domain;

public class LadderBaseLine {
    private final LadderGameUser ladderGameUser;
    private final ConnectPoints connectPoints;

    public LadderBaseLine(final LadderGameUser ladderGameUser, final ConnectPoints connectPoints) {
        this.ladderGameUser = ladderGameUser;
        this.connectPoints = connectPoints;
    }

    public boolean connectedWith(final int point) {
        return connectPoints.has(Point.of(point));
    }

    public boolean connectedWith(final Point point) {
        return connectPoints.has(point);
    }

    public LadderGameUser getLadderGameUser() {
        return ladderGameUser;
    }
}
