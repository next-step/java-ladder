package nextstep.ladder.domain.result;

import nextstep.ladder.domain.player.Player;

import java.util.HashMap;
import java.util.Map;

public class GameResults {
    private final Map<Player, Result> results = new HashMap<>();

    public GameResults() {
    }

    public void add(Player player, Result result) {
        this.results.put(player, result);
    }

    public void addAll(GameResults other) {
        other.results.forEach(this::add);
    }

    public Result findBy(Player player) {
        return results.get(player);
    }
}
