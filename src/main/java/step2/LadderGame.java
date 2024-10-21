package step2;

import step2.ganerator.LadderGenerator;
import step2.model.Ladder;
import step2.uiView.InputView;
import step2.uiView.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Ladder ladder = new Ladder(new LadderGenerator());
        ladder.createLadder(inputView.inputPerson(), inputView.inputMaxLadder());

        ResultView resultView = new ResultView();
        resultView.resultLadder(ladder);
    }
}
