package ladder.controller;

import ladder.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {
    public static void play() {
        InputView inputView = new InputView();
        inputView.setUserList();
        inputView.setResultList();
        inputView.setLadderHeight();

        Ladder ladder = new Ladder(inputView.getLadderWidth(), inputView.getLadderHeight());

        ResultView resultView = new ResultView(inputView.getUserList(), inputView.getResultList(), ladder);
        resultView.visualizeLadderGame();
        resultView.showResult();
    }
}
