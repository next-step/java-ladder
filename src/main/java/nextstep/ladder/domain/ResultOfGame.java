package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultOfGame {
    private final Map<PlayerName, Result> playerResultMap;

    private ResultOfGame(Map<PlayerName, Result> playerResultMap) {
        this.playerResultMap = Collections.unmodifiableMap(playerResultMap);
    }

    public static ResultOfGame of(Map<PlayerName, Result> playerResultMap) {
        if (playerResultMap == null) {
            throw new IllegalArgumentException("invalid input: result map cannot be null");
        }

        RailCount.validate(playerResultMap.size());

        return new ResultOfGame(playerResultMap);
    }

    public static ResultOfGame of(Players players, Results results) {
        return of(players.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        player -> results.elementOf(players.indexOf(player))
                )));
    }

    public Optional<Result> result(PlayerName playerName) {
        return Optional.ofNullable(playerResultMap.get(playerName));
    }

    public Stream<Map.Entry<PlayerName, Result>> streamOfEntry() {
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
