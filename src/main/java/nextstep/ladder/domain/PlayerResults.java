package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerResults {

    private final List<PlayerResult> playerResults;

    public PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public Map<Name, String> ladderResult(List<String> results) {
        return playerResults.stream()
                .collect(Collectors.toMap(PlayerResult::name, playerResult -> results.get(playerResult.endPoint()), (a, b) -> b));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerResults that = (PlayerResults) o;
        return Objects.equals(playerResults, that.playerResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerResults);
    }
}
