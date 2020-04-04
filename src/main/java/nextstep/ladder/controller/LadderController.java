package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void start() {
        List<String> participants = InputView.getParticipant();
        int height = InputView.getHeight();
        LadderGame ladderGame = new LadderGame(participants, height,
                new RandomRightDirection(),
                new RandomLineSelector());
        ResultView.displayResult(ladderGame);
    }

    private LadderController() {
    }
}
