package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.domain.LadderFactory.from;

public class LadderController {

    public void startGame(DirectionStrategy randomDirectionStrategy) {
        String names = InputView.askForPlayerNames();
        Names playerNames = new Names(names);
        Result result = new Result(InputView.askForResult());
        int height = InputView.askForMaxHeight();
        Ladder ladder = from(playerNames, new Height(height), randomDirectionStrategy);
        ResultView.showName(playerNames);
        ResultView.showLadder(ladder);
        ResultView.showResult(result);
    }
}
