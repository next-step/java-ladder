package ladder;

public class FirstElementStrategy implements LadderStrategy {
    private final Point point;

    public FirstElementStrategy(Point point) {
        this.point = point;
    }

    @Override
    public Direction direction() {
        if (RandomUtil.trueOrFalse()) {
            return Direction.RIGHT;
        }
        return Direction.NO_DIRECTION;
    }
}
