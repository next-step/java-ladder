package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;

public class LadderApp {
    public static void main(String[] args) {
        Participants participants = new Participants(InputView.inputParticipants());
        int ladderHeight = InputView.inputLadderHeight();

        new LadderGame(participants);
    }
}
