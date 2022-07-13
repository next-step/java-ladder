package ladder.domain.second;

import ladder.domain.PlayerName;
import ladder.domain.Players;
import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.engine.LineCreator;
import ladder.factory.LadderResultFactory;

import java.util.List;
import java.util.Map;

public class LadderGameResult implements LadderResult {
    private final List<String> results;

    public LadderGameResult(String prizeNames) {
        this(LadderResultFactory.splitPrizes(prizeNames));
    }

    public LadderGameResult(List<String> results) {
        this.results = results;
    }

    @Override
    public Players result(Players players, LadderCreator ladderCreator) {
        List<? extends LineCreator> lines = ladderCreator.getLines();
        Map<PlayerName, String> playerMap = players.getPlayers();
        for (LineCreator line : lines) {
            move(playerMap, (LadderLine) line);
        }
        resultOfGame(playerMap);
        return players;
    }

    private void resultOfGame(Map<PlayerName, String> playerMap) {
        for (PlayerName playerName : playerMap.keySet()) {
            playerMap.put(playerName, results.get(Integer.parseInt(playerMap.get(playerName))));
        }
    }

    private void move(Map<PlayerName, String> playerMap, LadderLine ladderLine) {
        for (PlayerName playerName : playerMap.keySet()) {
            playerMap.put(playerName, String.valueOf(ladderLine.move(Integer.parseInt(playerMap.get(playerName)))));
        }
    }
}
