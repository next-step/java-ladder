package ladder.model;

import java.util.Map;

public class LadderGameResult {
    private Map<Player, LadderPrize> ladderGameResult;

    public static LadderGameResult create(LadderResult ladderResult, LadderPrizes ladderPrizes) {
        return null;
    }

    public LadderPrize getLadderPrizeOfPlayer(Player player){
        return ladderGameResult.get(player);
    }
}
