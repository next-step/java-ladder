package ladder.domain.engine;

import ladder.exception.NoNameException;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Results {
    public static final String NO_NAME_MESSAGE = "플레이어 이름이 없습니다.";
    private final Map<PlayerName, RewardName> results;

    public Results(Map<PlayerName, RewardName> results) {
        this.results = results;
    }

    public RewardName result(PlayerName playerName) {
        return Optional.ofNullable(results.get(playerName))
                .orElseThrow(() -> new NoNameException(NO_NAME_MESSAGE));
    }

    public Map<PlayerName, RewardName> results() {
        return Collections.unmodifiableMap(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
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
