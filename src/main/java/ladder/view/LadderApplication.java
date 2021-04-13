package ladder.view;

import ladder.controller.LadderGameController;
import ladder.controller.LadderGenerationController;
import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGenerationResponse;

public class LadderApplication {

    public static void main(String[] args) {
        LadderGenerationController generationController = new LadderGenerationController();
        LadderGameController gameController = new LadderGameController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderGenerationResponse ladderGenerationResponse = generationController.generateLadder(inputView.inputLadderGeneration());
        outputView.printLadderGenerationResult(ladderGenerationResponse);

        LadderGameRequest gameRequest;
        while (true) {
            gameRequest = inputView.inputLadderGame(ladderGenerationResponse);
            if ("all".equals(gameRequest.getInquiryTargetName())) {
                outputView.printGameResults(gameController.inquiryGameResults(gameRequest));
                break;
            }
            outputView.printGameResult(gameController.inquiryGameResult(gameRequest));
        }
    }
}
