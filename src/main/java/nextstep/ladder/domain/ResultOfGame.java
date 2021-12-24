package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Prize;

public class ResultOfGame implements GameResult {
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

    public static ResultOfGame of(LadderFrame ladderFrame, List<Integer> resultIndexes) {
        Players players = ladderFrame.players();
        Prizes prizes = ladderFrame.prizes().mapByIndex(resultIndexes);
        // todo lambda style
        return of(players.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        player -> prizes.elementOf(players.indexOf(player))
                )));
    }

    public Optional<Prize> result(String playerName) {
        return Optional.ofNullable(playerResultMap.get(PlayerName.of(playerName)));
    }

    public Stream<Map.Entry<Name, Prize>> stream() {
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
