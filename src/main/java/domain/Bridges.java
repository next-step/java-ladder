package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bridges {

    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
        if (bridges.get(bridges.size() - 1).hasRightBridge()) {
            throw new IllegalArgumentException("마지막 다리의 우측에는 다리를 놓을 수 없습니다.");
        }
        this.bridges = bridges;
    }

    public static Bridges of(int column, BridgeCreationStrategy strategy) {
        List<Bridge> result = new ArrayList<>();
        Bridge prev = Bridge.firstOf(strategy.isCreate());
        result.add(prev);
        for (int i = 1; i < column - 1; i++) {
            Bridge next = getNext(strategy, prev);
            result.add(next);
            prev = next;
        }
        result.add(prev.next(false));
        return new Bridges(result);
    }

    private static Bridge getNext(BridgeCreationStrategy strategy, Bridge prev) {
        if (prev.hasRightBridge()) {
            return prev.next(false);
        }
        return prev.next(strategy.isCreate());
    }

    public Direction move(int column) {
        return bridges.get(column).move();
    }

    public int total() {
        return this.bridges.size();
    }

    public List<Boolean> getTotalBridge() {
        return bridges.stream()
                .map(bridge -> bridge.move().isSame(Direction.RIGHT))
                .collect(Collectors.toList());
    }
}
