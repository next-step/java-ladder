package nextstep.ladder;

import nextstep.ladder.domain.strategy.RandomBridgeStrategy;

public class Application {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new RandomBridgeStrategy());
        ladderGame.run();
    }
}
