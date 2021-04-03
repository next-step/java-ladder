package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        LadderGame ladderGame = new LadderGame(inputView.receivePlayerNames(), inputView.receiveLadderHeight());

        resultView.printPlayers(ladderGame.getPlayers());
        resultView.printLadder(ladderGame.getLadder());
    }

}
