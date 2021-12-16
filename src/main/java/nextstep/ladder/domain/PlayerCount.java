package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PlayerCount extends Count {
    private static final Map<Integer, PlayerCount> cache = new HashMap<>();

    private PlayerCount(final int playerCount) {
        super(playerCount);
        cache.put(playerCount, this);
    }

    public static PlayerCount of(final int playerCount) {
        if (cache.containsKey(playerCount)) {
            return cache.get(playerCount);
        }

        validate(playerCount);

        return new PlayerCount(playerCount);
    }

    public static void validate(final int playerCount) {
        if (playerCount < LadderFrame.MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + playerCount);
        }
    }
}
