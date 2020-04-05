package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {
    
    public static void main(String[] args) {
        LadderGame ladderGame = LadderGame.of(InputView.inputNames(), InputView.inputHeight());
        ResultView.print(ladderGame.getResult());
    }
}
