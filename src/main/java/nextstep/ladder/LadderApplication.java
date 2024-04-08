package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.generator.RandomLineGenerator;
import nextstep.ladder.service.LadderService;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new LadderService(new RandomLineGenerator()));
        ladderController.play();
    }
}
