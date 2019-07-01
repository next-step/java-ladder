package nextstep.step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players create(List<String> playersName) {
        return new Players(playersName.stream()
                                      .map(Player::new)
                                      .collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return players.stream()
                      .map(Player::new)
                      .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return this.players.size();
    }
}
