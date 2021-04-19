package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.LadderResultView;
import ladder.view.PrizeInputView;
import ladder.view.PrizeResultView;

public class LadderController {
    public void startLadderGame() {
        try {
            InputView inputView = new InputView();
            inputView.inputLadderCondition();

            Ladder ladder = Ladder.make(inputView.playersCount(), inputView.getLadderHeight());

            LadderResultView ladderResultView = new LadderResultView(inputView.getPlayers(), ladder);
            ladderResultView.showLadderDrawResult(inputView.getPrize());

            PrizeInputView prizeInputView = new PrizeInputView();
            PrizeResultView prizeResultView = new PrizeResultView(ladderResultView.getLadderResult(), inputView.getPrize());
            while (!prizeInputView.isAll()) {
                prizeInputView.inputPlayerNameForPrize();
                prizeResultView.printPrizeResult(prizeInputView, inputView.getPlayers());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
