package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Name;
import nextstep.ladder.exception.ExceptionMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    public static final int MINIMUN_PLAYERS = 2;

    private final List<Name> players;

    public Players(List<String> names) {
        validateDuplicateName(names);

        players = names.stream()
            .map(Name::new)
            .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplicateName(List<String> names) {
        long countOfName = countName(names);

        if (countOfName != names.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NAME.message());
        }

        validateNumOfPlayers(countOfName);
    }

    private long countName(List<String> names) {
        return names.stream()
            .map(String::toLowerCase)
            .distinct()
            .count();
    }

    private void validateNumOfPlayers(long countOfName) {
        if (countOfName < MINIMUN_PLAYERS) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_ENOUGH_PLAYER.message());
        }
    }

    public String names() {
        return players.stream()
            .map(player -> String.format("%-6s", player.toString()))
            .collect(Collectors.joining());
    }

    public String name(int startPosition) {
        return players.get(startPosition).toString();
    }

    public int numOfPlayers() {
        return players.size();
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
