package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderPoint;
import ladder.view.PrintLadder;
import ladder.view.InputView;

public class PlayLadderGame {
    public void playGame() {
        String names = InputView.inputNames();
        String winnings = InputView.inputLadderResult();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(names, ladderHeight, winnings);

        PrintLadder printLadder = new PrintLadder();
        printLadder.printNames(ladderGame.getPerson());
        printLadder.printLadder(ladderGame.getLadder());
        printLadder.printWinnings(ladderGame.getWinnings());

        String resultWinnings = InputView.wantNameToResult();
        printLadder.printOneWinningResult(ladderGame.getWinningResult(resultWinnings));

        resultWinnings = InputView.wantNameToResult();
        printLadder.printAllWinningResult(ladderGame.getWinningResult(resultWinnings));
        printLadder.printAllWinningResult(ladderGame.getWinningResult("all"));
    }
}
