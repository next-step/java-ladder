package ladder;

import ladder.domain.Ladder;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.OutputView;


public class LadderApplication {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Ladder ladder = new Ladder(inputView.inputNames(), inputView.inputPrizes(), inputView.inputHeight());
        outputView.printLadder(ladder);

        Results results = ladder.getResults();
        String name;
        while ((name = inputView.inputNameForResult()) != null){
            outputView.printResult(results, name);
        }
        outputView.printAllResult(results);
    }
}
