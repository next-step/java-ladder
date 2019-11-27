package reladder;

import reladder.controller.LadderController;
import reladder.domain.Ladder;
import reladder.domain.MatchUp;
import reladder.service.LadderGame;
import reladder.view.InputView;
import reladder.view.ResultView;

import java.util.Map;

public class LadderResponse {

    private static final String END_KEY = "all";

    private LadderController ladderController;

    public LadderResponse() {
        ladderController = new LadderController();
    }

    public void printLadderGame() {
        LadderGame ladderGame = ladderController.execute();
        ResultView.printLadderGame(ladderGame);
    }

    public void printResult() {
        String requestResultName = InputView.inputWantResult();
        while (!requestResultName.equals(END_KEY)) {
            String result = ladderController.result(requestResultName);
            ResultView.printResultOnce(result);
            requestResultName = InputView.inputWantResult();
        }
    }

    public void printResultAll() {
        Map<String, Object> result = ladderController.resultAll();
        ResultView.printResult(result);
    }
}
