package step3.domain;

import java.util.Objects;

public class Participant {
    private Name name;
    private ParticipantPosition position;

    private Participant(Name name, ParticipantPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Participant of(Name name, ParticipantPosition position) {
        return new Participant(name, position);
    }

    public Name getName() {
        return name;
    }

    public ParticipantPosition getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
