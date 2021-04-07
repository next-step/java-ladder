package nextstep.ladder.view.dto;

import nextstep.ladder.domain.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNamesDto {

    private List<String> playerNames;

    public PlayerNamesDto(List<Player> players) {
        this.playerNames = players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public List<String> names() {
        return Collections.unmodifiableList(playerNames);
    }
}
