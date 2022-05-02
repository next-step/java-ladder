package nextstep.ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Ladders ladders;
    private final Players players;

    public LadderGame(Ladders ladders, Players players) {
        this.ladders = ladders;
        this.players = players;
    }

    public Map<String, String> findResultByPlayerName(String playerName) {
        if (playerName.equals("all")) {
            return ladders.findAllLadderResult(players);
        }
        Map<String, String> results = new HashMap<>();
        results.put(playerName, ladders.findLadderResult(players.findPositionByPlayerName(playerName)));
        return results;
    }

}
