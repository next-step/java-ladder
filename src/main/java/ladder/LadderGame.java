package ladder;

import ladder.model.Ladder;
import ladder.model.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        InputView.printPlayerNameInputMessage();
        Players players = new Players(InputView.inputPlayerNames());

        InputView.printLadderHeightInputMessage();
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(players.count(), ladderHeight);

        ResultView.printResult(players.getNames(), ladder.getLines());
    }
}
