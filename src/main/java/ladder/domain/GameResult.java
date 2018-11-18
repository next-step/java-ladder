package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {

    private Map<Player, Result> results;

    public GameResult(Map<Player, Result> results) {
        this.results = new HashMap<>();
        this.results = results;
    }

    public Result findPlayerResult(String name) {
        return results.get(new Player(name));
    }

    @Override
    public String toString() {
        return results.keySet().stream()
                .map(player -> String.format("%s : %s", player, results.get(player)))
                .collect(Collectors.joining("\n"));
    }
}
