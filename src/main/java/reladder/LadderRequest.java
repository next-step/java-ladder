package reladder;

import ladder.view.InputView;
import reladder.controller.LadderController;
import reladder.domain.MatchUp;
import reladder.service.LadderGame;

import java.util.Map;

public class LadderRequest {

    private LadderController ladderController = new LadderController();

    public MatchUp register() {
        String names = InputView.inputName();
        String result = InputView.inputResult();
        return ladderController.register(names, result);
    }

    public LadderGame create(MatchUp matchUp) {
        int height = InputView.inputLadderHeight();
        return ladderController.create(matchUp, height);
    }

    public String request() {
        return InputView.inputWantResult();
    }

    public String response(LadderGame ladderGame, String name) {
        return ladderController.result(ladderGame, name);
    }

    public Map<String, Object> responseAll(LadderGame ladderGame) {
        return ladderController.allResult(ladderGame);
    }
}
