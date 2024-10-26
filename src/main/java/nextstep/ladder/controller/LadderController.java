package nextstep.ladder.controller;

import nextstep.ladder.service.LadderService;
import nextstep.ladder.view.View;
import nextstep.ladder.vo.Result;

public class LadderController {
    private final View view;
    private final LadderService ladderService;

    public LadderController(final View view, final LadderService ladderService) {
        this.view = view;
        this.ladderService = ladderService;
    }

    public void run() {
        String names = view.inputNames();
        String executeResult = view.inputExecuteResult();
        int countLadderHeight = view.inputCountLadderHeight();

        Result result = ladderService.play(names, executeResult, countLadderHeight);

        view.output(result);
    }
}
