package nextstep.ladder;

import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;

public class LadderController {

    public void startGame() {
        String names = InputView.askForPlayerNames();
        Names playerNames = new Names(names);
        int height = InputView.askForMaxHeight();
    }
}
