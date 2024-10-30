package nextstep.ladder.controller;

import nextstep.ladder.domain.Participants;
import nextstep.ladder.ui.InputView;

public class LadderGame {
    public static void main(String[] args) {
        Participants participants = new Participants(InputView.inputParticipantsName());
    }
}
