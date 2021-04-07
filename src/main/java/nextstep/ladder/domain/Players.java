package nextstep.ladder.domain;

import nextstep.ladder.view.dto.PlayerNamesDto;

import java.util.Collections;
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

    public PlayerNamesDto readOnlyPlayerNames() {
        return new PlayerNamesDto(Collections.unmodifiableList(players));
    }
}
