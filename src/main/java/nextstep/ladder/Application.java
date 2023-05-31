package nextstep.ladder;

import nextstep.ladder.controller.NextStepLadderGame;
import nextstep.ladder.domain.strategy.RandomBridgeStrategy;

public class Application {

    public static void main(String[] args) {
        NextStepLadderGame ladderGame = new NextStepLadderGame(new RandomBridgeStrategy());
        ladderGame.run();
    }
}
