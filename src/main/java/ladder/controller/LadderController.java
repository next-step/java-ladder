package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.RandomConnectStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public LadderController() {
    }

    public void run() {
        String names = InputView.inputParticipantNames();
        int height = InputView.inputMaxLadderHeight();
        Player player = new Player(names);

        Ladder ladder = new Ladder(player.getNames().size(), height);
        ladder.draw(new RandomConnectStrategy());

        ResultView.printParticipantNames(player);
        ResultView.printLadder(ladder);
    }
}
