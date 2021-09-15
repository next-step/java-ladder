package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    private Map<Player, PlayResult> result = new HashMap<>();

    public void put(Player player, PlayResult playResult) {
        result.put(player, playResult);
    }

    public PlayResult find(Player player) {
        if (!result.containsKey(player)) {
            throw new IllegalArgumentException("찾는 플레이어가 없습니다. Player 정보를 다시 확인하세요. player: " + player);
        }
        return result.get(player);
    }

    public Map<Player, PlayResult> getResult() {
        return result;
    }
}
