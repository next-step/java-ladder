package ladder;

import ladder.controller.LadderController;

public class LadderApplication {

    public static void main(String[] args) {
        LadderController controller = new LadderController();
        controller.start();
    }
}
