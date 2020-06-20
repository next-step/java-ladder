package ladder.domain;

import java.util.List;
import java.util.Optional;

public class Players {

    private static final int MIN_COUNT = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = Optional.ofNullable(players)
                .filter(this::isValidCount)
                .orElseThrow(() -> new IllegalArgumentException("Player는 2명 이상 가능합니다."));
    }

    private boolean isValidCount(List<Player> player) {
        return player.size() > MIN_COUNT;
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }
}
