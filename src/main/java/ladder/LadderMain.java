package ladder;

import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;
import ladder.service.LadderGameCreateService;
import ladder.service.LadderGameResultService;

public class LadderMain {

    public static void main(String[] args) {
        LadderGameCreateService ladderGameCreateService = new LadderGameCreateService(new LadderNotContinuousConnectStrategy());
        LadderGameResultService ladderGameResultService = new LadderGameResultService();

        LadderController ladderController = new LadderController(ladderGameCreateService, ladderGameResultService);
        ladderController.gameStart();
    }
}
