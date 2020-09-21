package nextstep.ladder.domain.ladderGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderGameResult {
    private final Map<Player, LadderReward> results;

    public static LadderGameResult from(final Map<Player, LadderReward> results) {
        return new LadderGameResult(results);
    }

    private LadderGameResult(final Map<Player, LadderReward> results) {
        this.results = new HashMap<>(Collections.unmodifiableMap(results));
    }

    public Map<Player, LadderReward> getResults() {
        return results;
    }

    public LadderReward getLadderReward(final String player) {
        return results.get(Player.from(player));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameResult)) return false;
        final LadderGameResult that = (LadderGameResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
