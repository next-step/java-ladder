package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;


public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Ladder ladder = new Ladder(inputView.inputNames(), inputView.inputHeight());
        outputView.printNames(ladder.getNames());
        outputView.printLadder(ladder.getLines());
    }
}
