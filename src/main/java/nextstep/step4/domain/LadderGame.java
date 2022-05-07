package nextstep.step4.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final LadderResult ladderResult;

    private LadderGame(Players players, Ladder ladder, LadderResult ladderResult) {
        this.players = players;
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public static LadderGame of(Players players, Ladder ladder, LadderResult ladderResult) {
        return new LadderGame(players, ladder, ladderResult);
    }

    public Map<PlayerName, String> findResultsByPlayerName(String playerName) {
        if (isAll(playerName)) {
            return findAllResult();
        }
        return findOneLadderResultByPlayerName(playerName);
    }

    private boolean isAll(String playerName) {
        return playerName.equals("all");
    }

    private Map<PlayerName, String> findAllResult() {
        Map<PlayerName, String> results = new HashMap<>();

        for (int playerColumn = 0; playerColumn < players.getCountOfPlayer(); playerColumn++) {
            addLadderResult(results, playerColumn);
        }

        return results;
    }

    private Map<PlayerName, String> findOneLadderResultByPlayerName(String playerName) {
        Map<PlayerName, String> result = new HashMap<>();

        int playerColumn = players.findColumnByPlayerName(playerName);
        addLadderResult(result, playerColumn);

        return result;
    }

    private void addLadderResult(Map<PlayerName, String> result, int playerColumn) {
        result.put(players.findPlayerByColumn(playerColumn), ladderResult.findLadderResultByEndColumn(ladder.findEndColumByStartColumn(playerColumn)));
    }
}
