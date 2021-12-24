package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import nextstep.ladder.engine.Count;

public class RailCount implements Count {
    public static final int MINIMUM_RAIL_COUNT = 2;

    private static final Map<Integer, RailCount> cache = new HashMap<>();

    private final int count;

    private RailCount(final int count) {
        this.count = count;
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

    public int toInt() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RailCount other = (RailCount) o;
        return count == other.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
