package ladder;

import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        String names = InputView.inputCandidateNames();
        Integer maxHeight = InputView.inputMaxLadderHeight();

        ResultView.printResult();
    }
}
