package ladder;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderResults;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import static ladder.view.ResultView.PLAYER_NAME_FOR_ALL_LADDER_RESULT;

public class LadderGameApp {
    public static void main(String[] args) {
        InputView.printPlayerNameInputMessage();
        Players players = new Players(InputView.inputPlayerNames());

        InputView.printLadderResultInputMessage();
        LadderResults results = new LadderResults(InputView.inputLadderResults());

        InputView.printLadderHeightInputMessage();
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(players.count(), ladderHeight);

        LadderGame ladderGame = new LadderGame(players, ladder, results);
        ResultView.printLadder(ladderGame);

        InputView.printPlayerNameForRadderResultInputMessage();
        InputView.inputNextLine();
        String playerNameForLadderResult = InputView.inputPlayerNameForLadderResult();
        ResultView.printLadderResult(ladderGame, playerNameForLadderResult);

        while (!PLAYER_NAME_FOR_ALL_LADDER_RESULT.equals(playerNameForLadderResult)) {
            InputView.printPlayerNameForRadderResultInputMessage();
            playerNameForLadderResult = InputView.inputPlayerNameForLadderResult();
            ResultView.printLadderResult(ladderGame, playerNameForLadderResult);
        }
    }
}
