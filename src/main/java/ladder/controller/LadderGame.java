package ladder.controller;

import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

public class LadderGame {

    public void start(){
        Players players = new Players(InputView.inputPlayerNames());
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = createLadder(players, ladderHeight);

        ResultView.showResult(players, ladder);
    }

    private Ladder createLadder(Players players, int ladderHeight) {
        return new Ladder(players.getPlayerNum(), ladderHeight);
    }

}
