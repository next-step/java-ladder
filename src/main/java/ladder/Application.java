package ladder;

import ladder.domain.LadderFactory;
import ladder.domain.PlayersGroup;
import ladder.view.InputView;

public class Application {

    public static void main(String[] args) {
        PlayersGroup playersGroup = PlayersGroup.of(InputView.inputPlayerNames());
        LadderFactory ladderFactory = new LadderFactory(InputView.inputLadderHeight());


    }
}
