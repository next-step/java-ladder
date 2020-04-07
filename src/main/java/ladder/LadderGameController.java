package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {

    public static void main(String[] args) {
        ResultView.print(LadderGame.of(InputView.inputNames(), InputView.inputHeight()));
    }
}
