package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class RailCount extends Count {
    public static final int MINIMUM_RAIL_COUNT = 2;
    private static final Map<Integer, RailCount> cache = new HashMap<>();

    private RailCount(int count) {
        super(count);
    }

    public static RailCount of(int railCount) {
        if (cache.containsKey(railCount)) {
            return cache.get(railCount);
        }

        if (railCount < MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid number of rail: must be larger than or equal to 2, but " + railCount);
        }

        RailCount newRailCount = new RailCount(railCount);
        cache.put(railCount, newRailCount);
        return newRailCount;
    }
}
