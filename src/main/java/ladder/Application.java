package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        PlayersGroup playersGroup = PlayersGroup.of(InputView.inputPlayerNames());
        GamePrizesGroup gamePrizesGroup = GamePrizesGroup.of(InputView.inputGamePrizeNames(), playersGroup);

        LadderFactory ladderFactory = new LadderFactory(InputView.inputLadderHeight());
        DrawingLineStrategy drawingLineStrategy = new RandomDrawingLineStrategy();
        Ladder ladder = ladderFactory.buildLadder(playersGroup, drawingLineStrategy);


        OutputView.printPlayerNames(playersGroup);
        OutputView.printLadder(ladder);
    }
}
