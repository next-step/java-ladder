package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameHandler {
    public static void runGame() {
        ParticipantService participantService = new ParticipantService();

        Participants participants = inputAndRegisterParticipant(participantService);
        ResultView.enter();

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.generate(participants.count(), ladderHeight);
        ResultView.enter();

        ResultView.printResultWord();
        ResultView.printParticipantsName(participants);
        ResultView.printLadder(ladder);
    }

    private static Participants inputAndRegisterParticipant(ParticipantService participantService) {
        String inputParticipantName = InputView.inputParticipantName();
        Participants participants = participantService.registerParticipant(inputParticipantName);
        return participants;
    }
}
