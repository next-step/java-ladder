package nextstep.ladder.domain;

import java.util.Objects;

public class Participant {
    public static final int PARTICIPANT_SIZE = 5;

    private final String participant;

    private Participant(String participant) {
        checkParticipantLength(participant);
        this.participant = participant;
    }

    public static Participant of(String participant) {
        return new Participant(participant);
    }

    private void checkParticipantLength(String participant) {
        if (participant.length() > PARTICIPANT_SIZE) {
            throw new IllegalArgumentException("이름의 길이가 " + PARTICIPANT_SIZE + "를 초과합니다.");
        }
        if (participant.length() == 0) {
            throw new IllegalArgumentException("이름의 길이가 0보다 커야합니다.");
        }
    }

    public String getParticipant() {
        return participant;
    }

    public int getParticipantLength() {
        return participant.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant);
    }
}
