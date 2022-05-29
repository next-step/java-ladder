package nextstep.ladder.doman;

public class Participant {

    private static final String NOT_NULL_PARTICIPANT_NAME = "이름은 필수 입니다.";

    private final ParticipantName participantName;

    public Participant(ParticipantName participantName) {
        validate(participantName);
        this.participantName = participantName;
    }

    private void validate(ParticipantName participantName) {
        if (participantName == null) {
            throw new IllegalArgumentException(NOT_NULL_PARTICIPANT_NAME);
        }
    }

    @Override
    public String toString() {
        return participantName.toString();
    }
}
