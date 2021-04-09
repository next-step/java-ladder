package ladder.view;

import ladder.controller.LadderGenerationController;

public class LadderApplication {

    public static void main(String[] args) {
        LadderGenerationController controller = new LadderGenerationController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printLadderGenerationResult(controller.generateLadder(inputView.inputLadderGeneration()));
    }
}
