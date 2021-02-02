package step2;

import step2.UI.InputView;
import step2.UI.OutputView;

public class Controller {

    public static void run() {
        String playersNames = InputView.inputPlayerName();
        Players players = Players.newPlayers(playersNames);

        String resultName = InputView.inputResultName();
        Results results = Results.newResults(resultName, players);

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.newLadder(ladderHeight, players.size());

        OutputView.outputView(ladder.getLines(), players.getPlayers());
    }
}
