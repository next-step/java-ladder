package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.generator.RandomLineGenerator;
import nextstep.ladder.service.LadderMaker;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new LadderMaker(new RandomLineGenerator()));
        ladderController.play();
    }
}
