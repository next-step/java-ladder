package ladder.controller;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.player.PlayerGroup;
import ladder.domain.WinningCategories;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private InputView inputView;
    private ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        String playerNames = inputView.readPlayerNames();
        String winningList = inputView.readResultGroup();
        LadderHeight ladderHeight = new LadderHeight(inputView.readHeight());

        PlayerGroup playerGroup = new PlayerGroup(playerNames);
        WinningCategories winningCategories = new WinningCategories(winningList);
        Ladder ladder = new Ladder(ladderHeight, playerGroup.size());

        resultView.printLadder(ladder, playerGroup);
        resultView.printResultGroup(winningCategories);

        LadderGame ladderGame = new LadderGame(ladder, playerGroup);
        ladderGame.start();

        resultView.printResult(winningCategories, playerGroup, ladderGame.getLadderResult());
    }
}
