package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.PrizeInputView;
import ladder.view.PrizeResultView;
import ladder.view.ResultView;

public class LadderController {
    public void startLadderGame() {
        try {
            InputView inputView = new InputView();
            inputView.inputLadderCondition();

            Ladder ladder = new Ladder();
            for (int i = 0; i < inputView.getLadderHeight(); i++) {
                Line ladderLine = new LineGenerator().generate(inputView.playersCount());
                ladder.add(ladderLine);
            }

            Players players = inputView.getPlayers();
            LadderResult ladderResult = new LadderResult(players.count(), ladder);

            ResultView resultView = new ResultView(players, ladderResult);
            resultView.showLadderDrawResult();
            resultView.printPrize(inputView.getPrize());

            PrizeInputView prizeInputView = new PrizeInputView();
            PrizeResultView prizeResultView = new PrizeResultView(ladderResult, inputView.getPrize());
            while (!prizeInputView.isAll()) {
                prizeInputView.inputPlayerNameForPrize();
                prizeResultView.printPrizeResult(prizeInputView, players);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
