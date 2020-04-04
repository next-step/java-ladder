package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderSize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void start() {
        List<String> participants = InputView.getParticipant();
        int height = InputView.getHeight();
        LadderSize ladderSize = new LadderSize(participants.size(), height);
        Ladder ladder = new Ladder(ladderSize, new RandomRightDirection(),
                new RandomLineSelector());
        ResultView.displayResult(participants, ladder);
    }

    private LadderController() {
    }
}
