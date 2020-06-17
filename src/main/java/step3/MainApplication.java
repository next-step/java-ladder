package step3;

import step3.domain.LadderGame;
import step3.domain.MatchingResult;
import step3.domain.Players;
import step3.domain.WinningPrizes;
import step3.view.InputView;
import step3.view.OutputView;

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
