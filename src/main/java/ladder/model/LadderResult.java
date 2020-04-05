package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Player, Integer> ladderResult;

    public LadderResult(Map<Player, Integer> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult create(Players players, Rows rows) {
        Map<Player, Integer> result = new HashMap<>();
        players.getPlayers().stream()
                .forEach(it -> result.put(it, it.findFinalLocation(rows)));
        return new LadderResult(result);
    }

    public int getSize(){
        return ladderResult.size();
    }
}
