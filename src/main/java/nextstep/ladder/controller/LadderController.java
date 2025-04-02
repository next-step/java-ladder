package nextstep.ladder.controller;

import java.util.Arrays;
import java.util.List;

import nextstep.ladder.domain.Junction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Leg;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        List<String> participantNames = inputView.getParticipantNames();
        int height = inputView.getLadderHeight();

        Ladder ladder = LadderFactory.createLadder(participantNames, height);

        resultView.printLadder(ladder);
    }

}
