package nextstep.laddergame.controller;

import java.util.List;

import nextstep.laddergame.model.Ladder;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;

public class LadderGameController {

    public void start() {
        List<Participant> participants = InputView.acceptParticipants();
        Ladder ladder = new Ladder(participants.size(), InputView.acceptMaxLadderHeight());

        ResultView.printLadder(participants, ladder.getLines());
    }
}
