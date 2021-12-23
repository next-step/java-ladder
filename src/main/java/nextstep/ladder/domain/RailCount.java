package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

import nextstep.ladder.engine.Count;

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

        validate(railCount);

        RailCount newRailCount = new RailCount(railCount);
        cache.put(railCount, newRailCount);
        return newRailCount;
    }

    public static void validate(final int railCount) {
        if (railCount < MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid rail count: must be larger than 2, but " + railCount);
        }
    }
}
