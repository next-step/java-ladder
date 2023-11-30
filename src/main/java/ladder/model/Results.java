package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Results {

    private final Map<Player, Prize> results;

    public Results(Map<Player, Prize> results) {
        this.results = results;
    }

    public static Results of(List<Player> players, LadderGame ladderGame, List<Prize> prizes) {
        Map<Player, Prize> results = new HashMap<>();
        IntStream.range(0, players.size())
                .forEach(index -> results.put(players.get(index), prizes.get(ladderGame.move(index))));

        return new Results(results);
    }

    public Map<Player, Prize> getResults() {
        return this.results;
    }
}
