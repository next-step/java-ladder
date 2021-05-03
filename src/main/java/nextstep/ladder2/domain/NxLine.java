package nextstep.ladder2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NxLine {
    private final List<NxBridge> bridges;

    public NxLine(List<Boolean> booleans) {
        List<Direction> directions = new ArrayList<>();
        Direction direction = Direction.first(booleans.get(0));
        directions.add(direction);
        for (int i = 1; i <= booleans.size() - 1; i++) {
            direction = direction.next(booleans.get(i));
            directions.add(direction);
        }
        directions.add(direction.last());

        bridges = new ArrayList<>(directions.size());
        for (int i = 0; i < directions.size(); i++) {
            bridges.add(new NxBridge(i, directions.get(i)));
        }
    }

    public int movePosition(int pointIndex) {
        return getBridge(pointIndex).movePosition();
    }

    private NxBridge getBridge(int index) {
        if (index < 0) {
            return bridges.get(0);
        }
        return bridges.get(index);
    }

    public List<Boolean> getBridgeValues() {
        return bridges.stream()
                .map(NxBridge::isEnabled)
                .collect(Collectors.toList());
    }
}
