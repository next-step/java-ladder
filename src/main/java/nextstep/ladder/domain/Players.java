package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayersDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Players {

    private static final String DELIMITER = ",";

    private final List<Player> players;

    public Players(final String names) {
        players = Arrays.stream(names.split(DELIMITER))
                .map(Player::new)
                .collect(toList());
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int count() {
        return players.size();
    }

}
