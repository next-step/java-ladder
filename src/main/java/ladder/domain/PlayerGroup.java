package ladder.domain;

import ladder.domain.exception.DuplicateNameException;
import ladder.domain.exception.NotEnoughPlayerToPlayException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PlayerGroup {

    private static final int MINIMUM_PLAYER = 2;

    private final List<Player> players;

    public PlayerGroup(final List<Player> players) {
        validateNumberOfPlayer(players);
        validateDuplicateName(players);
        this.players = players;
    }

    public static PlayerGroup from(final List<String> names) {
        AtomicInteger index = new AtomicInteger();
        return new PlayerGroup(
                Optional.ofNullable(names)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(name -> new Player(name, index.getAndIncrement(), 0))
                        .collect(Collectors.toList())
        );
    }

    private void validateNumberOfPlayer(final List<Player> players) {
        int size = Optional.ofNullable(players)
                .map(List::size)
                .orElse(0);
        if (size < MINIMUM_PLAYER) {
            throw new NotEnoughPlayerToPlayException(MINIMUM_PLAYER);
        }
    }

    private void validateDuplicateName(List<Player> players) {
        long deduplicationCount = players.stream()
                .map(Player::getName)
                .distinct()
                .count();

        if (players.size() != deduplicationCount) {
            throw DuplicateNameException.getInstance();
        }
    }

    public NumberOfLine findNumberOfPlayer() {
        return new NumberOfLine(players.size() - 1);
    }

    public List<Name> findNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerGroup that = (PlayerGroup) o;
        return Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "PlayerGroup{" +
                "players=" + players +
                '}';
    }
}
