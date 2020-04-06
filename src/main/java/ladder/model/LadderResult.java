package ladder.model;

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
