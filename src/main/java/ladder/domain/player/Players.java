package ladder.domain.player;

import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(final List<String> names) {
        validateNames(names);
        this.players = names.stream()
                .map(Player::of)
                .collect(Collectors.toList());
    }

    public static Players of(List<String> names) {
        return new Players(names);
    }

    private void validateNames(final List<String> names) {
        if (Objects.isNull(names) || names.size() == 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_OR_EMPTY);
        }
    }

    public int count() {
        return this.players.size();
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }
}
