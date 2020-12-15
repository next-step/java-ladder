package ladder;

import ladder.controller.LadderController;

public class Client {

    public static void main(String[] args) {
        LadderController controller = new LadderController();

        controller.run();
    }
}
