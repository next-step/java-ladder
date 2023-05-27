package ladder.domain.ladder;

import ladder.domain.player.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class LadderResult {

    private final Map<Player, Integer> result = new HashMap<>();

    public void put(Player player, Integer value) {
        result.put(player, value);
    }

    public Integer get(Player key) {
        return result.get(key);
    }

    public Stream<Player> keyStream() {
        return result.keySet().stream();
    }

    public Map<Player, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
