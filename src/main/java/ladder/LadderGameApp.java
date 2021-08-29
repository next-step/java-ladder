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
        Players players = new Players(InputView.inputPlayerNames());
        LadderResults results = new LadderResults(InputView.inputLadderResults());

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(players.count(), ladderHeight);

        LadderGame ladderGame = new LadderGame(players, ladder, results);
        ResultView.printLadder(ladderGame);

        String playerNameForLadderResult = InputView.inputPlayerNameForLadderResult();
        ResultView.printLadderResult(ladderGame, playerNameForLadderResult);

        while (!PLAYER_NAME_FOR_ALL_LADDER_RESULT.equals(playerNameForLadderResult)) {
            playerNameForLadderResult = InputView.inputPlayerNameForLadderResult();
            ResultView.printLadderResult(ladderGame, playerNameForLadderResult);
        }
    }
}
