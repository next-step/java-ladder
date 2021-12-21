package ladder;

import ladder.config.LadderConfig;
import ladder.controller.LadderController;

public class LadderApplication {

    public static void main(String[] args) {

        LadderConfig config = new LadderConfig();
        LadderController controller = new LadderController(config);

        controller.start();

    }

}
