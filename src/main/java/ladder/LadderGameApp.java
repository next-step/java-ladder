package ladder;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApp {
    public static final String PLAYER_NAME_FOR_ALL_LADDER_RESULT = "all";

    public static void main(String[] args) {
        Players players = new Players(InputView.inputPlayerNames());
        LadderResults results = new LadderResults(InputView.inputLadderResults());

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(players.count(), ladderHeight);

        LadderGame ladderGame = new LadderGame(players, ladder, results);
        PlayerResults playerResults = ladderGame.play();
        ResultView.printLadder(ladderGame);

        String inputPlayerName = InputView.inputPlayerNameForLadderResult();
        while (!PLAYER_NAME_FOR_ALL_LADDER_RESULT.equals(inputPlayerName)) {
            ResultView.printLadderResult(playerResults.findLadderResult(inputPlayerName));
            inputPlayerName = InputView.inputPlayerNameForLadderResult();
        }

        ResultView.printAllLadderResult(playerResults.getPlayerResults());
    }
}
