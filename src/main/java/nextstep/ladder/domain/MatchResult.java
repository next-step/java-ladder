package nextstep.ladder.domain;

import nextstep.ladder.dto.PlayerResult;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class MatchResult {

    private final Map<String, PlayerResult> results;

    public MatchResult(Map<String, PlayerResult> results) {
        this.results = results;
    }

    public static MatchResult of(List<Player> players, List<String> ladderResults) {
        Map<String, PlayerResult> results = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            results.put(players.get(i).getName(), new PlayerResult(players.get(i), ladderResults.get(i)));
        }
        return new MatchResult(results);
    }

    public PlayerResult playResult(String playerName) {
        return Optional.ofNullable(results.get(playerName))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("[%s] 참가자에 해당하는 사다리 결과가 없습니다.", playerName)));
    }

    public Collection<PlayerResult> allPlayResults() {
        return Collections.unmodifiableCollection(results.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchResult that = (MatchResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(results);
    }
}
