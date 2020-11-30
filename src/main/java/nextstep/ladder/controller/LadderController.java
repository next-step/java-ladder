package nextstep.ladder.controller;

import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();

        Participants participants = new Participants(inputView.inputParticipants());
    }
}
