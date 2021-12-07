package nextstep.laddergame;

import nextstep.laddergame.controller.LadderGameController;
import nextstep.laddergame.service.LadderGameService;

public class Runner {

    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController(new LadderGameService());
        controller.start();
    }
}
