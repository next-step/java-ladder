package ladder;

public class BodyElementStrategy implements LadderStrategy {
    private final Point point;
    private final Point previousPoint;

    public BodyElementStrategy(Point point, Point previousPoint) {
        this.point = point;
        this.previousPoint = previousPoint;
    }

    @Override
    public String direction() {
        if (previousPoint.haveRightDirection()) {
            return "LEFT";
        }

        if (RandomUtil.trueOrFalse()) {
            return "RIGHT";
        }

        return "";
    }
}
