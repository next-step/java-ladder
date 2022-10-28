package ladder;

import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;

public class LadderMain {

    public static void main(String[] args) {
        LadderGameCreateService ladderGameCreateService = new LadderGameCreateService(new LadderNotContinuousConnectStrategy());
        LadderController ladderController = new LadderController(ladderGameCreateService);
        ladderController.gameStart();
    }
}
