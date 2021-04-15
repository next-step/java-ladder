package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameApplication {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            inputView.inputPlayer();
            inputView.inputLadderHeight();

            LadderController ladderController = new LadderController(inputView);
            ResultView resultView = ladderController.startLadderGame();

            resultView.printOutPlayers();
            System.out.println();
            resultView.printOutLineResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
