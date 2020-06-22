package ladder.domain.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Players {

    private static final int MIN_COUNT = 2;

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = Optional.ofNullable(players)
                .filter(this::isValidCount)
                .orElseThrow(() -> new IllegalArgumentException("Player는 2명 이상 가능합니다."));
    }

    private boolean isValidCount(List<Player> player) {
        return MIN_COUNT <= player.size();
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }

    public int getCount() {
        return players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());
    }
}
