package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultOfGame {
    private final Map<Player, Result> playerResultMap;

    private ResultOfGame(Map<Player, Result> playerResultMap) {
        this.playerResultMap = Collections.unmodifiableMap(playerResultMap);
    }

    public static ResultOfGame of(Map<Player, Result> playerResultMap) {
        if (playerResultMap == null || playerResultMap.size() < LadderFrame.MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("invalid input: result map cannot be null and larger than 2");
        }

        return new ResultOfGame(playerResultMap);
    }

    public static ResultOfGame of(Players players, Results results) {
        return of(players.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        player -> results.elementOf(players.indexOf(player))
                )));

    }

    public Optional<Result> result(Player player) {
        return Optional.ofNullable(playerResultMap.get(player));
    }

    public Stream<Map.Entry<Player, Result>> streamOfEntry() {
        return playerResultMap.entrySet()
                .stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultOfGame that = (ResultOfGame) o;
        return Objects.equals(playerResultMap, that.playerResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerResultMap);
    }

    @Override
    public String toString() {
        return "ResultOfGame{" +
                "playerResultMap=" + playerResultMap +
                '}';
    }
}
