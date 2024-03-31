package nextstep.ladder.domain;

import java.util.Objects;

public class ParticipantPosition {

    private final Participant participant;
    private final int position;

    public static ParticipantPosition of(String name, int position) {
        return new ParticipantPosition(Participant.of(name), position);
    }

    public static ParticipantPosition of(Participant participant, int position) {
        return new ParticipantPosition(participant, position);
    }

    private ParticipantPosition(Participant participant, int position) {
        this.participant = participant;
        this.position = position;
    }

    public String getParticipantName() {
        return this.participant.getName();
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantPosition that = (ParticipantPosition) o;
        return position == that.position && Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, position);
    }
}
