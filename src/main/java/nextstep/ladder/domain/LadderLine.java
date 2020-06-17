package nextstep.ladder.domain;

public class LadderLine {
    private final ConnectPoints connectPoints;

    private LadderLine(final ConnectPoints connectPoints) {
        this.connectPoints = connectPoints;
    }

    public static LadderLine of(final ConnectPoints connectPoints) {
        return new LadderLine(connectPoints);
    }

    public boolean connectedWith(final int point) {
        return connectPoints.has(Point.of(point));
    }

    public boolean connectedWith(final Point point) {
        return connectPoints.has(point);
    }

}
