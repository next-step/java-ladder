package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerResults {

    private final List<PlayerResult> playerResults;

    public PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public PlayerResults(Ladder ladder) {
        Names names = ladder.getNames();
        Lines lines = ladder.getLines();
        this.playerResults = IntStream.range(0, names.size())
                .mapToObj(i -> new PlayerResult(names.name(i), lines.findEndPoint(i)))
                .collect(Collectors.toList());
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
