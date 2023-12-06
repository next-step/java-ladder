package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerList) {
        return new Players(playerList.stream().map(Player::from).collect(Collectors.toList()));
    }

    public List<Player> list() {
        return this.players;
    }
}
