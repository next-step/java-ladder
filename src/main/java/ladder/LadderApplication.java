package ladder;

import ladder.controller.LadderController;
import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLine;

public class LadderApplication {

    public static void main(String[] args) {

        LineStrategy strategy = new RandomLine();
        LadderController controller = new LadderController(strategy);

        controller.start();

    }

}
