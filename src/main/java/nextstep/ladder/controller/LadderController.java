package nextstep.ladder.controller;

import nextstep.ladder.domain.user.Users;
import nextstep.ladder.result.LadderResult;
import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void play() {
        Users users = ladderService.makeUsers(InputView.inputUserNames());
        int ladderHeight = InputView.inputLadderHeight();

        LadderResult ladderResult = ladderService.generateLadder(users, ladderHeight);

        ResultView.viewResult(ladderResult);
    }
}
