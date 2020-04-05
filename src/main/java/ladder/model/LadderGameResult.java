package ladder.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {
    private Map<Player, LadderPrize> ladderGameResult;

    public LadderGameResult(Map<Player, LadderPrize> ladderGameResult) {
        this.ladderGameResult = Collections.unmodifiableMap(ladderGameResult);
    }

    public static LadderGameResult create(LadderResult ladderResult, LadderPrizes ladderPrizes) {
        Map<Player, LadderPrize> result = new HashMap<>();
        for (int i = 0; i < ladderResult.getSize(); i++) {
            result.put(ladderResult.findPlayerAtIndex(i), ladderPrizes.findPrizeAtIndex(i));
        }
        return new LadderGameResult(result);
    }

    public LadderPrize findPrizeOfPlayer(Player player){
        return ladderGameResult.get(player);
    }
}
