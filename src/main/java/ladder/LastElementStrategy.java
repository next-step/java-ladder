package ladder;

public class LastElementStrategy implements LadderStrategy {
    private final Point point;
    private final Point previousPoint;

    public LastElementStrategy(Point point, Point previousPoint) {
        this.point = point;
        this.previousPoint = previousPoint;
    }

    @Override
    public String direction() {
        if (previousPoint.haveRightDirection()) {
            return "RIGHT";
        }
        return "";
    }
}
