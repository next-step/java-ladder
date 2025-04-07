package ladder;

import ladder.domain.LadderFactory;
import ladder.view.InputView;
import ladder.view.OutputView;


public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderFactory ladderFactory = new LadderFactory(inputView.inputNames(), inputView.inputHeight());
        outputView.printNames(ladderFactory.getNames());
        outputView.printLadders(ladderFactory.getLadder());
    }
}
