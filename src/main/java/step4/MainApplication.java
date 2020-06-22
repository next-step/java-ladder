package step4;

import step4.domain.LadderGame;
import step4.domain.MatchingResult;
import step4.domain.Players;
import step4.domain.WinningPrizes;
import step4.view.InputView;
import step4.view.OutputView;

public class MainApplication {

    public static void main(String[] args) {
        // input player
        Players players = InputView.createPlayers();
        // input winning prize
        WinningPrizes winningPrizes = InputView.createWinningPrizes();
        // ladders setting
        int laddersHeight = InputView.inputLadderHeight();
        LadderGame ladderGame = LadderGame.createLadder(players, winningPrizes, laddersHeight);
        // draw ladders
        // ladderGame output
        OutputView.output(ladderGame);
        // play & result
        MatchingResult matchingResult = ladderGame.calculateWinningPrizeLine();
        // result output
        OutputView.outputResultView(matchingResult);
    }
}
