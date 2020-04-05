package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Integer, Player> ladderResult;

    public LadderResult(Map<Integer, Player> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult create(Players players, Rows rows) {
        Map<Integer, Player> result = new HashMap<>();
        for(Player player:players.getPlayers()){
            result.put(player.findFinalLocation(rows), player) ;
        }
        return new LadderResult(result);
    }

    public Player findPlayerAtIndex(int index) {
        return ladderResult.get(index);
    }

    public int getSize() {
        return ladderResult.size();
    }
}
