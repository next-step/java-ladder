package ladder;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderResults;
import ladder.model.Players;
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
        ResultView.printLadder(ladderGame);

        String inputPlayerName = InputView.inputPlayerNameForLadderResult();
        while (!PLAYER_NAME_FOR_ALL_LADDER_RESULT.equals(inputPlayerName)) {
            ResultView.printLadderResult(ladderGame.findLadderResult(inputPlayerName));
            inputPlayerName = InputView.inputPlayerNameForLadderResult();
        }

        ResultView.printAllLadderResult(ladderGame.findAllPlayerResult());
    }
}
