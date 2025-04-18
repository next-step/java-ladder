package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.view.InputView;
import ladder.view.OutputView;


public class LadderApplication {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Ladder ladder = new Ladder(inputView.inputNames(), inputView.inputPrizes(), inputView.inputHeight());
        outputView.printLadder(ladder);

        LadderResult result = ladder.run();
        String name;
        while ((name = inputView.inputNameForResult()) != null){
            outputView.printResult(result, name);
        }
        outputView.printAllResult(result);
    }
}
