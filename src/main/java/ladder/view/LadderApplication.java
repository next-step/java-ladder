package ladder.view;

import ladder.controller.LadderGameController;
import ladder.controller.dto.LadderGameResponse;

public class LadderApplication {

    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderGameResponse ladderGameResponse = gameController.executeLadderGame(inputView.inputLadderGeneration());
        outputView.printLadderGenerationResult(ladderGameResponse);

        while (true) {
            String inputInquiryTargetName  = inputView.inputInquiryTargetName();
            if ("all".equals(inputInquiryTargetName)) {
                outputView.printGameResults(ladderGameResponse.getLadderGameResults());
                break;
            }
            outputView.printGameResult(ladderGameResponse.getLadderGameResults(), inputInquiryTargetName);
        }
    }
}
