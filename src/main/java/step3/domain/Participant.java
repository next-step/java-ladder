package step3.domain;

import java.util.Objects;

public class Participant {
    private ParticipantName participantName;
    private final int position;

    private Participant(ParticipantName participantName, int position) {
        this.participantName = participantName;
        this.position = position;
    }

    public static Participant of(ParticipantName participantName, int position) {
        return new Participant(participantName, position);
    }

    public ParticipantName getName() {
        return participantName;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participantName, that.participantName) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName, position);
    }
}
