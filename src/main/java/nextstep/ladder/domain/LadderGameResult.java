package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Prize;

public class LadderGameResult implements GameResult {
    private final Map<Name, Prize> playerResultMap;

    private LadderGameResult(Map<Name, Prize> playerResultMap) {
        this.playerResultMap = Collections.unmodifiableMap(playerResultMap);
    }

    public static LadderGameResult of(Map<Name, Prize> playerResultMap) {
        if (playerResultMap == null) {
            throw new IllegalArgumentException("invalid input: result map cannot be null");
        }

        LadderRailCount.validate(playerResultMap.size());

        return new LadderGameResult(playerResultMap);
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
        LadderGameResult that = (LadderGameResult) o;
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
