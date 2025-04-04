package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.views.InputView;
import ladder.views.ResultView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Players players = InputView.createPlayersWithQuery();
        int height = InputView.createIntegerWithQuery();
        LadderGame ladderGame = new LadderGame(players, height);

        ResultView.printResult(ladderGame);
    }
}
