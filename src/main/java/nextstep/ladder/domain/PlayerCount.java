package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlayerCount {
    private static final int MINIMUM_PLAYER_COUNT = 2;
    private static final Map<Integer, PlayerCount> cache = new HashMap<>();

    private final int playerCount;

    private PlayerCount(final int playerCount) {
        this.playerCount = playerCount;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCount that = (PlayerCount) o;
        return playerCount == that.playerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerCount);
    }

    public int toInt() {
        return playerCount;
    }
}
