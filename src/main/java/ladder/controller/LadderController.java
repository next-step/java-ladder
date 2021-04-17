package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import ladder.domain.Players;
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
                Line ladderLine = new Line(inputView.playersCount());
                ladder.add(ladderLine);
            }

            Players players = inputView.getPlayers();
            LadderResult ladderResult = new LadderResult(players, ladder);

            ResultView resultView = new ResultView(ladderResult);
            resultView.showLadderDrawResult();
            resultView.printPrize(inputView.getPrize());

            PrizeInputView prizeInputView = new PrizeInputView();
            PrizeResultView prizeResultView = new PrizeResultView(ladderResult, inputView.getPrize());
            while (!prizeInputView.isAll()) {
                prizeInputView.inputPlayerNameForPrize();
                prizeResultView.printPrizeResult(prizeInputView);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
