package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class PlayerCount extends Count {
    private static final int MINIMUM_PLAYER_COUNT = 2;
    private static final Map<Integer, PlayerCount> cache = new HashMap<>();

    private PlayerCount(final int playerCount) {
        super(playerCount);
    }

    public static PlayerCount of(final int playerCount) {
        if (cache.containsKey(playerCount)) {
            return cache.get(playerCount);
        }

        validate(playerCount);

        PlayerCount instance = new PlayerCount(playerCount);
        cache.put(playerCount, instance);
        return instance;
    }

    public static void validate(final int playerCount) {
        if (playerCount < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException("invalid number of player: must be larger than 2, but " + playerCount);
        }
    }
}
