package nextstep.ladder.domain;

public class LadderLine {
    private final LadderGameUser ladderGameUser;
    private final ConnectPoints connectPoints;

    private LadderLine(final LadderGameUser ladderGameUser, final ConnectPoints connectPoints) {
        this.ladderGameUser = ladderGameUser;
        this.connectPoints = connectPoints;
    }

    public static LadderLine of(final LadderGameUser ladderGameUser, final ConnectPoints connectPoints) {
        return new LadderLine(ladderGameUser, connectPoints);
    }

    public boolean connectedWith(final int point) {
        return connectPoints.has(Point.of(point));
    }

    public boolean connectedWith(final Point point) {
        return connectPoints.has(point);
    }

    public String getUserName() {
        return ladderGameUser.getUserName();
    }
}
