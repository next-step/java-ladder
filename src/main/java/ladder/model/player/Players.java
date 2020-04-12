package ladder.model.player;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static ladder.Messages.WARNING_NOT_ALLOWED_DUPLICATION_NAME;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        validateDuplicationName(players);
        this.players = Collections.unmodifiableList(players);
    }

    public static Players create(List<Player> players) {
        return new Players(players);
    }

    public int getPlayerCount() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int findIndexOf(Player player) {
        return players.indexOf(player);
    }

    private void validateDuplicationName(List<Player> players) {
        players.stream()
                .filter(player -> Collections.frequency(findNames(players), player.getName()) > 1)
                .findAny()
                .ifPresent(player -> {
                    throw new IllegalArgumentException(WARNING_NOT_ALLOWED_DUPLICATION_NAME);
                });
    }

    private List<PlayerName> findNames(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .collect(toList());
    }
}