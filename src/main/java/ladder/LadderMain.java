package ladder;

import ladder.domain.ladder.strategy.LadderConnectType;
import ladder.view.output.ConsoleOutputView;

public class LadderMain {

    public static void main(String[] args) {
        LadderController ladderController
                = new LadderController(LadderConnectType.DISCONTINUOUS, new ConsoleOutputView());

        ladderController.gameStart();
    }
}
