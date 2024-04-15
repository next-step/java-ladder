package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bridges {

    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
        if (bridges.get(bridges.size() - 1).has()) {
            throw new IllegalArgumentException("마지막 다리의 우측에는 다리를 놓을 수 없습니다.");
        }
        this.bridges = bridges;
    }

    public static Bridges of(int column, BridgeCreationStrategy strategy) {
        List<Bridge> result = new ArrayList<>();
        Bridge prev = Bridge.first(strategy.isCreate());
        result.add(prev);
        for (int i = 1; i < column - 1; i++) {
            Bridge next = prev.next(strategy.isCreate());
            result.add(next);
            prev = next;
        }
        result.add(prev.next(false));
        return new Bridges(result);
    }

    public Direction move(int column) {
        return bridges.get(column).move();
    }

    public int total() {
        return this.bridges.size();
    }
}
