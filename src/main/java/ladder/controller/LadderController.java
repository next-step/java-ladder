package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void run(){
        Players players = new Players(InputView.enterPlayers());
        Ladder ladder = new Ladder(players.numberOfPlayer(), InputView.enterHeight());
        ResultView.printResult(players,ladder);
    }
}
