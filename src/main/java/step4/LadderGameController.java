package step4;

import step4.domain.Ladder;
import step4.view.InputView;

public class LadderGameController {
    public void run() {
        String userNames = InputView.requireUserName();
        String resultNames = InputView.requireResultNames();
        Integer height = InputView.requireHeight();
        Ladder ladder = Ladder.init()
    }
}
