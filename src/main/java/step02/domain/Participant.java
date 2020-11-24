package step02.domain;

import java.util.Objects;

public class Participant {
    private final ParticipantName participantName;

    private Participant(ParticipantName participantName) {
        this.participantName = participantName;
    }

    public static Participant of(String name) {
        return new Participant(ParticipantName.of(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participantName, that.participantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName);
    }
}
