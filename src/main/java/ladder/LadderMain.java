package ladder;

import ladder.domain.ladder.strategy.LadderNotContinuousConnectStrategy;

public class LadderMain {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new LadderNotContinuousConnectStrategy());

        ladderController.gameStart();
    }
}
