package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.engine.Name;

public class ResultOfGame {
    private final Map<Name, Prize> playerResultMap;

    private ResultOfGame(Map<Name, Prize> playerResultMap) {
        this.playerResultMap = Collections.unmodifiableMap(playerResultMap);
    }

    public static ResultOfGame of(Map<Name, Prize> playerResultMap) {
        if (playerResultMap == null) {
            throw new IllegalArgumentException("invalid input: result map cannot be null");
        }

        RailCount.validate(playerResultMap.size());

        return new ResultOfGame(playerResultMap);
    }

    public static ResultOfGame of(Players players, Prizes prizes) {
        return of(players.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        player -> prizes.elementOf(players.indexOf(player))
                )));
    }

    public Optional<Prize> result(PlayerName playerName) {
        return Optional.ofNullable(playerResultMap.get(playerName));
    }

    public Stream<Map.Entry<Name, Prize>> streamOfEntry() {
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
