package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class ResultCount extends Count {
    private static final Map<Integer, ResultCount> cache = new HashMap<>();

    protected ResultCount(int count) {
        super(count);
        cache.put(count, this);
    }

    public ResultCount of(int count) {
        if (cache.containsKey(count)) {
            return cache.get(count);
        }

        if (count < LadderBuilder.MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid count: must be larger than 2, but" + count);
        }

        return new ResultCount(count);
    }
}
