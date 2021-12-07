package ladder;

import ladder.domain.LadderGame;
import ladder.ui.InputView;
import ladder.ui.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        String names = InputView.readNames();
        int height = InputView.readHeight();

        LadderGame ladderGame = new LadderGame(names, height);

        OutputView.printResult(ladderGame);
    }

}
