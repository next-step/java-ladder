package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;

public class LadderController {

    public void startGame(DirectionStrategy randomDirectionStrategy) {
        String names = InputView.askForPlayerNames();
        Names playerNames = new Names(names);
        int height = InputView.askForMaxHeight();
        Ladder ladder = LadderFactory.from(playerNames,new Height(height),randomDirectionStrategy);
    }
}
