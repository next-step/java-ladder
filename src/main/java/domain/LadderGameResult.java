package domain;

import lombok.Getter;

import java.util.Map;
import java.util.Set;

public class LadderGameResult {
    @Getter
    private Map<Player, Result> ladderGameResult;

    public LadderGameResult(Map<Player, Result> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public Result getResultOf(Player player) {
        return ladderGameResult.get(player);
    }

    public void printAll() {
        Set<Player> players = ladderGameResult.keySet();
        for (Player player : players) {
            System.out.println(player + ":" + ladderGameResult.get(player));
        }
    }

}
