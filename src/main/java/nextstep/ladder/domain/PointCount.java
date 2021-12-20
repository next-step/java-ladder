package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PointCount extends Count {
    private static final int MINIMUM_LINE_COUNT = 1;
    private static final int PLAYER_LINE_DIFF = 1;
    private static final Map<Integer, PointCount> cache = new HashMap<>();

    private PointCount(final int lineCount) {
        super(lineCount);
        cache.put(lineCount, this);
    }

    public static PointCount of(int lineCount) {
        if (cache.containsKey(lineCount)) {
            return cache.get(lineCount);
        }

        if (lineCount < MINIMUM_LINE_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + lineCount);
        }

        return new PointCount(lineCount);
    }

    public static PointCount of(PlayerCount playerCount) {
        if (playerCount == null) {
            throw new IllegalArgumentException("invalid player count: cannot be null");
        }

        return of(playerCount.toInt() - PLAYER_LINE_DIFF);
    }
}
