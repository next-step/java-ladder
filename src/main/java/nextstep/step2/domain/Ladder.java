package nextstep.step2.domain;

import java.util.Objects;

public class Ladder {

    private final ParticipantName participantName;
    private final int height;

    private Ladder(final ParticipantName participantName, final int height){
        this.participantName = participantName;
        this.height = height;
    }

    public static Ladder of(final ParticipantName participantName, final int height) {
        return new Ladder(participantName, height);
    }

    public ParticipantName getParticipantName() {
        return participantName;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return height == ladder.height && Objects.equals(participantName, ladder.participantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName, height);
    }
}
