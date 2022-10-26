package ladder;

import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;

public class LadderMain {

    public static void main(String[] args) {
        LadderService ladderService = new LadderService(new LadderNotContinuousConnectStrategy());
        LadderController ladderController = new LadderController(ladderService);
        ladderController.create();
    }
}
