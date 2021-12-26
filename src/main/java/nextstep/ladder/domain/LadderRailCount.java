package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import nextstep.ladder.engine.RailCount;

public class LadderRailCount implements RailCount {
    private static final Map<Integer, LadderRailCount> cache = new HashMap<>();

    private final int count;

    private LadderRailCount(final int count) {
        this.count = count;
    }

    public static LadderRailCount of(int railCount) {
        if (cache.containsKey(railCount)) {
            return cache.get(railCount);
        }

        validate(railCount);

        LadderRailCount newLadderRailCount = new LadderRailCount(railCount);
        cache.put(railCount, newLadderRailCount);
        return newLadderRailCount;
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
        LadderRailCount other = (LadderRailCount) o;
        return count == other.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
