package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players from(List<String> playerNames) {
        return new Players(playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public int countOfPerson() {
        return players.size();
    }

    public List<String> readOnlyPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean notIncludePlayer(Player player) {
        return !players.contains(player);
    }

    public int position(Player player) {
        return players.indexOf(player);
    }
}
