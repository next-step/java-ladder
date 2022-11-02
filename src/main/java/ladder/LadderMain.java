package ladder;

import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;
import ladder.service.LadderGameResultService;

public class LadderMain {

    public static void main(String[] args) {
        LadderGameResultService ladderGameResultService = new LadderGameResultService();

        LadderController ladderController = new LadderController(new LadderNotContinuousConnectStrategy(),
                ladderGameResultService);
        ladderController.gameStart();
    }
}
