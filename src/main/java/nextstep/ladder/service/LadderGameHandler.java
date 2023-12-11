package nextstep.ladder.service;

import nextstep.ladder.view.InputView;

public class LadderGameHandler {
    public static void runGame() {
        ParticipantService participantService = new ParticipantService();

        String inputParticipantName = InputView.inputParticipantName();
        participantService.registerParticipant(inputParticipantName);
    }
}
