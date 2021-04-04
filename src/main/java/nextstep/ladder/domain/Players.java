package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final String NAME_DELIMITER = " ";

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

    public String readOnlyPlayerNames() {
        List<String> playerNames = players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
        return String.join(NAME_DELIMITER, playerNames);
    }
}
