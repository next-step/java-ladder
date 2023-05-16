package step2;

import step2.domain.GameUsers;
import step2.domain.Ladder;
import step2.view.InputView;

public class LadderGameController {

    public void start() {
        GameUsers gameUsers = new GameUsers(InputView.readUserNames());
        Ladder ladder = new Ladder(InputView.readLadderHeight());
    }
}
