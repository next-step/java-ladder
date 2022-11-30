package nextstep;

import nextstep.ladder.LadderController;
import nextstep.ladder.domain.RandomDirectionStrategy;

public class LadderGameApplication {

    public static void main(String[] args) {

        RandomDirectionStrategy randomDirection = new RandomDirectionStrategy();
        new LadderController().startGame(randomDirection);
    }
}
