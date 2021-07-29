package nextstep.ladder.domain.player;

import nextstep.ladder.exception.NullArgumentException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<String> names) {
        validate(names);

        players = names.stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    private void validate(List<String> names) {
        if (Objects.isNull(names)) {
            throw new NullArgumentException("Names");
        }
    }

    public static Players init(List<String> names) {
        return new Players(names);
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int numberOfPlayers() {
        return players.size();
    }
}
