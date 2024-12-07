package ladder.domain.ns;

import ladder.domain.interfaces.Results;
import ladder.exception.NoNameException;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class NsResults implements Results {
    public static final String NO_NAME_MESSAGE = "플레이어 이름이 없습니다.";
    private final Map<PlayerName, RewardName> results;

    public NsResults(Map<PlayerName, RewardName> results) {
        this.results = results;
    }

    @Override
    public RewardName result(PlayerName playerName) {
        return Optional.ofNullable(results.get(playerName))
                .orElseThrow(() -> new NoNameException(NO_NAME_MESSAGE));
    }

    @Override
    public Map<PlayerName, RewardName> results() {
        return Collections.unmodifiableMap(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NsResults results1 = (NsResults) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                '}';
    }
}
