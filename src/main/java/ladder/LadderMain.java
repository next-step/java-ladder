package ladder;

import ladder.view.input.ConsoleInputView;
import ladder.view.output.ConsoleOutputView;

public class LadderMain {

    public static void main(String[] args) {
        ConsoleOutputView outputView = new ConsoleOutputView();
        ConsoleInputView inputView = new ConsoleInputView();

        LadderController ladderController = new LadderController(outputView, inputView);

        ladderController.gameStart();
    }
}
