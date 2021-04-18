package ladder.view;

import ladder.controller.LadderGameController;
import ladder.controller.dto.LadderGenerationResponse;

public class LadderApplication {

    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderGenerationResponse ladderGenerationResponse = gameController.generateLadderGame(inputView.inputLadderGeneration());
        outputView.printLadderGenerationResult(ladderGenerationResponse);

        while (true) {
            String inputInquiryTargetName  = inputView.inputInquiryTargetName();
            if ("all".equals(inputInquiryTargetName)) {
                outputView.printGameResults(ladderGenerationResponse.getLadderGameResults());
                break;
            }
            outputView.printGameResult(ladderGenerationResponse.getLadderGameResults(), inputInquiryTargetName);
        }
    }
}
