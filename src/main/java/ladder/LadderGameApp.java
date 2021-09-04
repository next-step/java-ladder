package ladder;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderResults;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGameApp {
    public static final String PLAYER_NAME_FOR_ALL_LADDER_RESULT = "all";
    private static final String EMPTY_RESULT = "";
    private static final Map<String, String> PLAYER_LADDER_RESULTS = new LinkedHashMap<>();

    public static void main(String[] args) {
        Players players = new Players(InputView.inputPlayerNames());
        putPlayerNameAndEmptyResultInPlayerLadderResults(players.getNames());

        LadderResults results = new LadderResults(InputView.inputLadderResults());

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(players.count(), ladderHeight);

        LadderGame ladderGame = new LadderGame(players, ladder, results);
        ResultView.printLadder(ladderGame);

        String inputPlayerName = InputView.inputPlayerNameForLadderResult();
        while (!PLAYER_NAME_FOR_ALL_LADDER_RESULT.equals(inputPlayerName)) {
            String playerLadderResult = cacheAndFindResult(ladderGame, inputPlayerName);
            ResultView.printLadderResult(playerLadderResult);
            inputPlayerName = InputView.inputPlayerNameForLadderResult();
        }

        printAllLadderResults(ladderGame);
    }

    private static void putPlayerNameAndEmptyResultInPlayerLadderResults(List<String> playerNames) {
        for (String playerName : playerNames) {
            PLAYER_LADDER_RESULTS.put(playerName, EMPTY_RESULT);
        }
    }

    private static String cacheAndFindResult(LadderGame ladderGame, String playerName) {
        String playerLadderResult = PLAYER_LADDER_RESULTS.get(playerName);
        if (!EMPTY_RESULT.equals(playerLadderResult)) {
            return playerLadderResult;
        }

        playerLadderResult = ladderGame.findResult(playerName);
        PLAYER_LADDER_RESULTS.put(playerName, playerLadderResult);
        return playerLadderResult;
    }

    private static void printAllLadderResults(LadderGame ladderGame) {
        for (String playerName : PLAYER_LADDER_RESULTS.keySet()) {
            cacheAndFindResult(ladderGame, playerName);
        }
        ResultView.printAllLadderResult(PLAYER_LADDER_RESULTS);
    }
}
