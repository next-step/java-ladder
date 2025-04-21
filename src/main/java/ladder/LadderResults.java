package ladder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResults {
    private final Map<Player, Integer> results;

    private LadderResults(Map<Player, Integer> results) {
        this.results = results;
    }

    public static LadderResults from(Players players, Ladder ladder) {
        Map<Player, Integer> resultMap = new LinkedHashMap<>();
        List<Player> all = players.players();

        for (int i = 0; i < all.size(); i++) {
            Player player = all.get(i);
            int resultIndex = ladder.move(i);
            resultMap.put(player, resultIndex);
        }

        return new LadderResults(resultMap);
    }
}
