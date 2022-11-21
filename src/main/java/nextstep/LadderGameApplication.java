package nextstep;

import nextstep.ladder.LadderController;
import nextstep.ladder.domain.RandomDirectionImpl;

public class LadderGameApplication {

    public static void main(String[] args) {

        RandomDirectionImpl randomDirection = new RandomDirectionImpl();
        new LadderController().startGame(randomDirection);
    }
}
