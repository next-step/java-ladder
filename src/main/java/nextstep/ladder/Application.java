package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.generator.RandomProductionGenerator;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new RandomProductionGenerator());
        ladderController.run();
    }
}
