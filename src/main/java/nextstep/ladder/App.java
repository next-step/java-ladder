package nextstep.ladder;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.ladder.LadderBound;
import nextstep.ladder.ladder.LadderPrizes;
import nextstep.ladder.strategy.RandomLadderStrategy;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class App {

    public static void main(String[] args) {
        LadderPrizes ladderPrizes = getLadderPrizes();
        LadderBound ladderBound = getLadderBound(ladderPrizes.getPlayers().count());
        Ladder ladder = Ladder.of(ladderBound, new RandomLadderStrategy());

        ResultView.printLadder(ladderPrizes, ladder);
        ResultView.printPlayerResult(ladderPrizes);

    }

    private static LadderPrizes getLadderPrizes() {
        String playerNames = InputView.getInputPlayerName();
        String prizesNames = InputView.getInputLadderPrize();
        return LadderPrizes.of(playerNames, prizesNames);
    }

    private static LadderBound getLadderBound(int count) {
        int height = InputView.getInputMaxLadderHeight();
        return LadderBound.of(count - 1, height);
    }
}
