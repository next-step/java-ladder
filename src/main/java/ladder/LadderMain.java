package ladder;

import ladder.domain.ladder.strategy.LadderConnectType;

public class LadderMain {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(LadderConnectType.DISCONTINUOUS);

        ladderController.gameStart();
    }
}
