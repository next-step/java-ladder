package ladder;

import ladder.domain.ladder.strategy.LadderConnectType;
import ladder.view.input.ConsoleInputView;
import ladder.view.output.ConsoleOutputView;

public class LadderMain {

    public static void main(String[] args) {
        ConsoleOutputView outputView = new ConsoleOutputView();
        ConsoleInputView inputView = new ConsoleInputView();

        LadderController ladderController
                = new LadderController(LadderConnectType.DISCONTINUOUS, outputView, inputView);

        ladderController.gameStart();
    }
}
