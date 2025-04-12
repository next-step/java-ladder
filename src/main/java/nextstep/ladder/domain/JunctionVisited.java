package nextstep.ladder.domain;

import java.util.Objects;

public class JunctionVisited {

    private final Junction junction;
    private final ParticipantName participant;

    public JunctionVisited(Junction junction, ParticipantName participant) {
        this.junction = junction;
        this.participant = participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JunctionVisited that = (JunctionVisited) o;
        return Objects.equals(junction, that.junction) && Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(junction, participant);
    }
}
