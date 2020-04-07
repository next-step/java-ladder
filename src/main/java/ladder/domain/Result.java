package ladder.domain;

import ladder.exception.PrizeNotFoundException;

import java.util.Collections;
import java.util.Map;

public class Result {
    private final Map<Player, Prize> result;

    public Result(final Map<Player, Prize> result) {
        this.result = result;
    }

    public String findOne(String name) {
        return result.entrySet()
                     .stream()
                     .filter(player -> player.getKey().same(new PlayerName(name)))
                     .map(Map.Entry::getValue)
                     .findFirst()
                     .map(Prize::getPrize)
                     .orElseThrow(PrizeNotFoundException::new);
    }

    public Prize get(Player player) {
        return result.get(player);
    }

    public Map<Player, Prize> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
