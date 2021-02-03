package step2;

import step2.UI.InputView;
import step2.UI.OutputView;

public class Controller {

    public static void run() {
        String playersNames = InputView.inputPlayerName();
        Players players = Players.newPlayers(playersNames);

        String result = InputView.inputResult();
        Results results = Results.newResults(result, players);

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.newLadder(ladderHeight, players.size());

        OutputView.outputLadder(ladder.getLines(), players, results);

        String resultPlayerName = InputView.inputResultPlayerName();
        OutputView.outputResultPlayer(players, resultPlayerName);
    }
}
