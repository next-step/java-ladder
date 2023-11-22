package nextstep.ladder.domain.wrapper;

import nextstep.ladder.domain.Player;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static nextstep.ladder.exception.ExceptionMessage.*;

public class Players {

    private final List<Player> players;
    public Players(List<Player> players) {
        validateNameUnique(players);

        this.players = players;
    }

    private void validateNameUnique(List<Player> players) {
        long countOfName = countName(players);

        if (countOfName != players.size()) {
            throw new IllegalArgumentException(NOT_EQUAL_NAME.message());
        }
    }

    private long countName(List<Player> players) {
        return players.stream()
            .map(player -> player.name().toLowerCase())
            .distinct()
            .count();
    }

    public List<String> names() {
        return players.stream()
            .map(Player::name)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
