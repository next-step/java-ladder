package nextstep.ladder;

import java.util.List;

public class LadderController {
    private InputView inputView;


    public void startGame() {
        List<String> names = inputView.inputNames();
        int ladderHeight = inputView.inputLadderHeight();
    }
}
