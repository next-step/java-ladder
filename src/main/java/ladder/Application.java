package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.PlayersGroup;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        PlayersGroup playersGroup = PlayersGroup.of(InputView.inputPlayerNames());
        LadderFactory ladderFactory = new LadderFactory(InputView.inputLadderHeight());
        Ladder ladder = ladderFactory.buildLadder(playersGroup);

        OutputView.printPlayerNames(playersGroup);
        OutputView.printLadder(ladder);
    }
}
