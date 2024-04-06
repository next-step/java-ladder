package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players of(List<String> playerNames) {
        List<Player> players = playerNames.stream().map(Player::new).collect(Collectors.toList());

        return new Players(players);
    }

    public int countOfPerson() {
        return players.size();
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }
}
