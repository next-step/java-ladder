package ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResults {
    private final Map<Player, Result> results;

    private LadderResults(Map<Player, Result> results) {
        this.results = results;
    }

    public static LadderResults from(Players players, Ladder ladder, Results results) {
        Map<Player, Result> resultMap = new LinkedHashMap<>();
        List<Player> all = players.players();

        for (int i = 0; i < all.size(); i++) {
            Player player = all.get(i);
            int resultIndex = ladder.move(i);
            resultMap.put(player, results.getResults().get(resultIndex));
        }

        return new LadderResults(resultMap);
    }
    public Map<Player, Result> getResultMap() {
        return Map.copyOf(results);
    }
}
