package nextstep.ladder.domain;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladders ladders;
    private final Players players;
    private final LaddersResults laddersResults;

    private LadderGame(Ladders ladders, Players players, LaddersResults laddersResults) {
        this.ladders = ladders;
        this.players = players;
        this.laddersResults = laddersResults;
    }

    public static LadderGame of(Ladders ladders, Players players, LaddersResults laddersResults) {
        return new LadderGame(ladders, players, laddersResults);
    }

    public void startGame(InputView inputView, ResultView resultView) {
        while(true) {
            String playerName = inputView.inputWinner();
            Map<PlayerName, String> resultMap = findResultByPlayerName(playerName);
            resultView.printPlayerResult(resultMap);
            if (isAll(playerName)) {
                break;
            }
        }
    }

    public Map<PlayerName, String> findResultByPlayerName(String playerName) {
        if (isAll(playerName)) {
            return findAllLadderResult();
        }

        return findOneLadderResultByPlayerName(playerName);
    }

    private boolean isAll(String playerName) {
        return playerName.equals("all");
    }

    private Map<PlayerName, String> findAllLadderResult() {
        Map<PlayerName, String> results = new HashMap<>();
        List<PlayerName> playerList = players.getPlayers();
        for (int i = 0; i < playerList.size(); i++) {
            results.put(playerList.get(i), laddersResults.findLadderResultByEndPosition(ladders.findLadderResult(i)));
        }
        return results;
    }

    private Map<PlayerName, String> findOneLadderResultByPlayerName(String playerName) {
        Map<PlayerName, String> result = new HashMap<>();

        int startPosition = players.findPositionByPlayerName(playerName);

        result.put(players.getPlayers().get(startPosition), laddersResults.findLadderResultByEndPosition(ladders.findLadderResult(startPosition)));

        return result;
    }
}
