package nextstep.ladder;

import nextstep.ladder.config.Config;
import nextstep.ladder.controller.LadderController;

public class MainApplication {
    public static void main(String[] args) {
        Config config = Config.getInstance();
        LadderController ladderController = config.ladderController();
        ladderController.run();
    }
}
