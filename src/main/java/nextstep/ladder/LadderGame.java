package nextstep.ladder;

import nextstep.ladder.service.LadderService;

public class LadderGame {

    public static void main(String... args) {
        LadderService ladderService = new LadderService();

        ladderService.initLadderGame();

        ladderService.printLadder();
    }
}
