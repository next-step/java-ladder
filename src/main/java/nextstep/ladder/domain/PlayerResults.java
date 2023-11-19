package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerResults {

    private final List<PlayerResult> playerResults;

    public PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public PlayerResults(Names names,
                         Lines lines,
                         List<String> result) {
        this.playerResults = IntStream.range(0, names.size())
                .mapToObj(i -> new PlayerResult(names.name(i), result.get(lines.findEndPoint(i))))
                .collect(Collectors.toList());
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
