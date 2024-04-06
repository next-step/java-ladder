package ladder.model;

import java.util.Objects;

public class Participant {
    public static final String INVALID_PARTICIPANT_NAME_LENGTH = "참가자의 이름 길이는 최대 5까지 가능합니다.";
    public static final int PARTICIPANT_NAME_LENGTH = 5;

    private final String participant;
    private final int startPoint;

    private Participant(String participant, int startPoint) {
        this.participant = participant;
        this.startPoint = startPoint;
    }

    public static Participant of(String participant, int startPoint) {
        if (participant.length() > PARTICIPANT_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_NAME_LENGTH);
        }

        return new Participant(participant, startPoint);
    }

    public String getParticipant() {
        return participant;
    }

    protected boolean isEqualParticipant(String name) {
        return Objects.equals(name, participant);
    }

    protected int getStartPoint() {
        return startPoint;
    }
}
