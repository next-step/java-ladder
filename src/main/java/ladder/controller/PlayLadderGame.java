package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderPoint;
import ladder.view.PrintLadder;
import ladder.view.InputView;

public class PlayLadderGame {

    public void playGame() {
        String names = InputView.inputNames();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, ladderHeight);

        PrintLadder printLadder = new PrintLadder();
        printLadder.printNames(ladderGame.getPerson());
        printLadder.printLadder(ladderGame.getLadder());
        printLadder.printWinnings(ladderGame.getWinnings());

        String winnings = InputView.wantNameToResult();
        printLadder.printOneWinningResult(ladderGame.getWinningResult(winnings));

        winnings = InputView.wantNameToResult();
        printLadder.printAllWinningResult(ladderGame.getWinningResult(winnings));
    }
}
