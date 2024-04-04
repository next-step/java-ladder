package ladder.model;

public class Participant {
    public static final String INVALID_PARTICIPANT_NAME_LENGTH = "참가자의 이름 길이는 최대 5까지 가능합니다.";
    public static final int PARTICIPANT_NAME_LENGTH = 5;

    private final String participant;

    private Participant(String participant) {
        this.participant = participant;
    }

    public static Participant of(String participant) {
        if (participant.length() > PARTICIPANT_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_NAME_LENGTH);
        }

        return new Participant(participant);
    }

    public String getParticipant() {
        return participant;
    }
}
