package nextstep.ladder.controller;

import nextstep.ladder.domain.user.Users;
import nextstep.ladder.result.LadderResult;
import nextstep.ladder.service.LadderMaker;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    private final LadderMaker ladderMaker;

    public LadderController(LadderMaker ladderMaker) {
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        Users users = new Users(InputView.inputUserNames());
        int ladderHeight = InputView.inputLadderHeight();

        LadderResult ladderResult = ladderMaker.generateLadder(users, ladderHeight);

        ResultView.viewResult(ladderResult);
    }
}
