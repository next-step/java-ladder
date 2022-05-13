package nextstep.ladder.application;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.service.LadderService;

public class LadderApplication {
    public static void main(String[] args) {
        new LadderController(new LadderService()).run();
    }
}
