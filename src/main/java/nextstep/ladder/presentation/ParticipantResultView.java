package nextstep.ladder.presentation;

import nextstep.ladder.domain.Participants;

public class ParticipantResultView {
    private static final String PARTICIPANT_NAME_PRINT_FORMAT = "%6s";

    private final Participants participants;

    public ParticipantResultView(Participants participants) {
        this.participants = participants;
    }

    public void printNames() {
        StringBuilder participantsName = new StringBuilder();
        participants.names()
                .forEach(participantName -> participantsName.append(printFormatOfParticipantName(participantName)));

        System.out.println(participantsName);
    }

    private String printFormatOfParticipantName(String participantName) {
        return String.format(PARTICIPANT_NAME_PRINT_FORMAT, participantName);
    }
}
