package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderPlayResult {
    private Map<Player, String> playResult;

    public LadderPlayResult() {
        playResult = new LinkedHashMap<>();
    }

    public void add(Player player, String gameResult){
        playResult.put(player, gameResult);
    }

    public String get(Player player){
        return playResult.get(player);
    }

    public Map<Player, String> getPlayResult() {
        return new LinkedHashMap<>(playResult);
    }
}
