package step2;

import step2.model.Ladder;
import step2.uiView.InputView;
import step2.uiView.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Ladder ladder = new Ladder();
        ladder.inputPerson(inputView.inputPerson(), inputView.inputMaxLadder());

        ResultView resultView = new ResultView();
        resultView.resultLadder(ladder);
    }
}
