package nextstep.ladder.domain;

import java.util.HashSet;
import java.util.Set;

public class JunctionVisitors {
    public final Set<ParticipantName> visitors = new HashSet<>();

    public boolean isVisited(ParticipantName participantName) {
        return visitors.contains(participantName);
    }

    public void visit(ParticipantName participantName) {
        visitors.add(participantName);
    }

}
