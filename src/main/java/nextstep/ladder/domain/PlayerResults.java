package nextstep.ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerResults {

    private final Map<Name, String> playerResults;

    public PlayerResults(Map<Name, String> playerResults) {
        this.playerResults = playerResults;
    }

    public PlayerResults(Names names,
                         Ladder lines,
                         List<String> result) {
        this.playerResults = IntStream.range(0, names.size())
                .mapToObj(i -> new PlayerResult(names.name(i), result.get(lines.findEndPoint(i))))
                .collect(Collectors.toMap(PlayerResult::name, PlayerResult::result, (s, s2) -> s));
    }

    public Map<Name, String> getAll() {
        return this.playerResults;
    }

    public String findByName(Name name) {
        return this.playerResults.get(name);
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
