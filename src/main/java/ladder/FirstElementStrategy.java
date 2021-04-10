package ladder;

public class FirstElementStrategy implements LadderStrategy {
    private final Point point;

    public FirstElementStrategy(Point point) {
        this.point = point;
    }

    @Override
    public String direction() {
        if (RandomUtil.trueOrFalse()) {
            return "RIGHT";
        }
        return "";
    }
}
