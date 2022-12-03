package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.domain.LadderFactory.from;

public class LadderController {

    public void startGame(DirectionStrategy randomDirectionStrategy) {
        Names playerNames = new Names(InputView.askForPlayerNames());
        Result result = new Result(InputView.askForResult());
        int height = InputView.askForMaxHeight();

        Ladder ladder = from(playerNames, new Height(height), randomDirectionStrategy);
        ladder.move(playerNames.size());
        ResultOfGame resultOfGame = new ResultOfGame(playerNames, ladder.result());

        ResultView.showName(playerNames);
        ResultView.showLadder(ladder);
        ResultView.showResult(result);

        String target = InputView.askWantToKnow();
        ResultView.showTargetResult(result,resultOfGame,target);
    }
}
