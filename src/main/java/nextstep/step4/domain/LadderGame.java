package nextstep.step4.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class LadderGame {

    private final Map<PlayerName, String> ladderGameResults;

    private final Players players;
    private final Ladder ladder;
    private final LadderResult ladderResult;

    private LadderGame(Players players, Ladder ladder, LadderResult ladderResult) {
        this.players = players;
        this.ladder = ladder;
        this.ladderResult = ladderResult;
        ladderGameResults = findAllResult();
    }

    public static LadderGame of(Players players, Ladder ladder, LadderResult ladderResult) {
        return new LadderGame(players, ladder, ladderResult);
    }

    private Map<PlayerName, String> findAllResult() {
        Map<PlayerName, String> ladderGameResults = new HashMap<>();
        for (int playerColumn = 0; playerColumn < players.getCountOfPlayer(); playerColumn++) {
            addLadderResult(ladderGameResults, playerColumn);
        }
        return ladderGameResults;
    }

    private void addLadderResult(Map<PlayerName, String> ladderGameResults, int playerColumn) {
        ladderGameResults.put(players.findPlayerByColumn(playerColumn), ladderResult.findLadderResultByEndColumn(ladder.findEndColumByStartColumn(playerColumn)));
    }

    public Map<PlayerName, String> findResultsByPlayerName(String playerName) {
        if (isAll(playerName)) {
            return unmodifiableMap(ladderGameResults);
        }

        return findOneResult(playerName);
    }

    private boolean isAll(String playerName) {
        return playerName.equals("all");
    }

    private Map<PlayerName, String> findOneResult(String playerName) {
        return ladderGameResults.entrySet()
                .stream()
                .filter(result -> result.getKey().equals(PlayerName.from(playerName)))
                .collect(toMap(Entry::getKey, Entry::getValue));
    }
}
