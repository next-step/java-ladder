package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderPlayResult {
    private final LadderPositionResult ladderPositionResult;
    private Map<Player, String> playResult;

    public LadderPlayResult(LadderPositionResult ladderPositionResult) {
        this.ladderPositionResult = ladderPositionResult;
        playResult = new LinkedHashMap<>();
    }

    public void add(Player player, int finalPosition){
        String gameResult = ladderPositionResult.findBy(finalPosition);
        playResult.put(player, gameResult);
    }

    public String get(Player player){
        return playResult.get(player);
    }

    public LadderPositionResult getLadderPositionResult() {
        return ladderPositionResult;
    }

    public Map<Player, String> getPlayResult() {
        return new LinkedHashMap<>(playResult);
    }
}
