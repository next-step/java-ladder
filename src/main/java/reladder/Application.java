package reladder;

import ladder.view.InputView;
import reladder.controller.LadderController;
import reladder.service.LadderGame;

public class Application {

    private static final String END_KEY = "all";

    public static void main(String[] args) {

        LadderController ladderController = new LadderController();

        String names = InputView.inputName();
        int height = InputView.inputLadderHeight();
        String result = InputView.inputResult();

        LadderGame ladderGame = ladderController.execute(names, height, result);

        String personName = InputView.inputWantResult();
        for (; !personName.equals(END_KEY); ) {
            ladderController.result(ladderGame, personName);
            personName = InputView.inputWantResult();
        }
        ladderController.allResult(ladderGame);
    }
}
