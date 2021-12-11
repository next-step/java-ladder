package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LineCount {
    private static final int MINIMUM_LINE_COUNT = 1;
    private static final int PLAYER_LINE_DIFF = 1;
    private static final Map<Integer, LineCount> cache = new HashMap<>();

    private final int lineCount;

    private LineCount(final int lineCount) {
        this.lineCount = lineCount;
    }

    public static LineCount of(int lineCount) {
        if (cache.containsKey(lineCount)) {
            return cache.get(lineCount);
        }

        if (lineCount < MINIMUM_LINE_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + lineCount);
        }

        LineCount instance = new LineCount(lineCount);
        cache.put(lineCount, instance);
        return instance;
    }

    public static LineCount of(PlayerCount playerCount) {
        if (playerCount == null) {
            throw new IllegalArgumentException("invalid player count: cannot be null");
        }

        return of(playerCount.toInt() - PLAYER_LINE_DIFF);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineCount lineCount1 = (LineCount) o;
        return lineCount == lineCount1.lineCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineCount);
    }

    public int toInt() {
        return lineCount;
    }
}
