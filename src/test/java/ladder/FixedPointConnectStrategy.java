package ladder;

import java.util.List;

public class FixedPointConnectStrategy implements PointConnectStrategy {
    private final List<Boolean> drawPossibilities;
    private int index = 0;

    public FixedPointConnectStrategy(List<Boolean> drawPossibilities) {
        this.drawPossibilities = drawPossibilities;
    }

    @Override
    public boolean isConnected() {
        return drawPossibilities.get(index++);
    }
}
