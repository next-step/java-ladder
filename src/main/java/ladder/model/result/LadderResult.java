package ladder.model.result;

import ladder.model.player.Player;
import ladder.model.player.Players;
import ladder.model.row.Rows;

import java.util.Map;

public class LadderResult {
    private Map<Player, Integer> ladderResult;

    public LadderResult(Map<Player, Integer> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult create(Players players, Rows rows) {
        return null;
    }

    public int getSize(){
        return ladderResult.size();
    }
}
