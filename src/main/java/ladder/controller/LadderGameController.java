package ladder.controller;

import ladder.model.LadderGame;
import ladder.model.LadderRandomStrategy;
import ladder.model.Player;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderGameController {

    public void play() {
        List<Player> players = InputView.readPlayerName();
        int height = InputView.readHeight();

        LadderGame ladderGame = new LadderGame(players, height, new LadderRandomStrategy());

        OutputView.printResult(ladderGame);
    }

}
