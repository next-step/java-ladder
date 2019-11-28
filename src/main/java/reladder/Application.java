package reladder;

import reladder.controller.LadderController;
import reladder.domain.DefaultLadderGenerator;
import reladder.view.InputView;
import reladder.view.ResultView;

public class Application {

    private static final String END_KEY = "all";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        LadderController ladderController = new LadderController(DefaultLadderGenerator.getInstance());

        String requestName = InputView.inputName();
        String requestResult = InputView.inputResult();
        int height = InputView.inputLadderHeight();

        LadderRequest ladderRequest = LadderRequest.of(requestName, requestResult, height);
        LadderResponse ladderResponse = ladderController.execute(ladderRequest);

        ResultView.printLadderGame(ladderResponse.getLadderGame());

        String requestResultName = InputView.inputWantResult();
        while (!requestResultName.equals(END_KEY)) {
            LadderResponse resultResponse = ladderController.result(ladderRequest, requestResultName);

            ResultView.printResultOnce(resultResponse.getResult());
            requestResultName = InputView.inputWantResult();
        }
        LadderResponse resultAllResponse = ladderController.resultAll(ladderRequest);

        ResultView.printResult(resultAllResponse.getResultAll());
    }
}
