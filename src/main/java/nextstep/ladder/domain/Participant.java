package nextstep.ladder.domain;

public class Participant {
    private static final String PARTICIPANT_LENGTH_ERROR = "참가자 이름은 5글자를 넘을 수 없습니다.";
    private static final int MAXIMUM_PARTICIPANT_LENGTH = 5;
    private final String participant;

    public Participant(String participant) {
        validateNameLength(participant);
        this.participant = participant;
    }

    private void validateNameLength(String participant) {
        if (participant.length() > MAXIMUM_PARTICIPANT_LENGTH) {
            throw new IllegalArgumentException(PARTICIPANT_LENGTH_ERROR);
        }
    }

    public String getParticipant() {
        return participant;
    }
}
