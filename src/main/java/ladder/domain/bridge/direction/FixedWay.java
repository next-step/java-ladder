package ladder.domain.bridge.direction;

public class FixedWay implements WayGenerator {

    private final boolean right;

    public FixedWay(boolean isRight) {
        this.right = isRight;
    }

    @Override
    public boolean getWay() {
        return this.right;
    }
}
