package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.PrizeInputView;
import ladder.view.PrizeResultView;
import ladder.view.ResultView;

public class LadderController {
    public void startLadderGame() {
        try {
            InputView inputView = new InputView();
            inputView.inputLadderCondition();

            Ladder ladder = Ladder.makeLadder(inputView.playersCount(), inputView.getLadderHeight());

            ResultView resultView = new ResultView(inputView.getPlayers(), ladder);
            resultView.showLadderDrawResult(inputView.getPrize());

            PrizeInputView prizeInputView = new PrizeInputView();
            PrizeResultView prizeResultView = new PrizeResultView(resultView, inputView.getPrize());
            while (!prizeInputView.isAll()) {
                prizeInputView.inputPlayerNameForPrize();
                prizeResultView.printPrizeResult(prizeInputView, inputView.getPlayers());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
