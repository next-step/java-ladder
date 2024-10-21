package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderPlayResult {
    private final Map<Player, String> playResult;

    public LadderPlayResult(Map<Player, String> playResult) {
        this.playResult = playResult;
    }

    public String get(Player player){
        return playResult.get(player);
    }

    public Map<Player, String> getPlayResult() {
        return new LinkedHashMap<>(playResult);
    }
}
