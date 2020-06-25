package step4;

import step4.domain.MatchingResult;
import step4.domain.Players;
import step4.domain.WinningPrizes;
import step4.refactoring.Ladder;
import step4.strategy.RandomLineStrategy;
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

        // new
        Ladder ladder = Ladder.of(players, laddersHeight, new RandomLineStrategy());
        // ladderGame output
        OutputView.output(players, winningPrizes, ladder);

        // play & result
        MatchingResult matchingResult = ladder.calculateWinningPrizeLine(players, winningPrizes);
        // result output
        OutputView.outputResultView(matchingResult);
    }
}
