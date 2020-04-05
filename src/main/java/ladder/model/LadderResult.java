package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private Map<Integer, Player> ladderResult;

    public LadderResult(Map<Integer, Player> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult create(Players players, Rows rows) {
        Map<Integer, Player> result = new HashMap<>();
        players.getPlayers().stream()
                .forEach(it -> result.put(it.findFinalLocation(rows), it));
        return new LadderResult(result);
    }

    public Player findPlayerAtIndex(int index){
        return ladderResult.get(index);
    }

    public int getSize(){
        return ladderResult.size();
    }
}
