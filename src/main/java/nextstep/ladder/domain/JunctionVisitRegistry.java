package nextstep.ladder.domain;

import java.util.HashSet;
import java.util.Set;

public class JunctionVisitRegistry {
    private final Set<JunctionVisited> visits = new HashSet<>();

    public void visit(Junction junction, ParticipantName participant) {
        if (isVisited(junction, participant)) {
            throw new IllegalStateException("이미 방문한 참가자입니다.");
        }

        visits.add(new JunctionVisited(junction, participant));
    }

    public boolean isVisited(Junction junction, ParticipantName participant) {
        return visits.contains(new JunctionVisited(junction, participant));
    }

}
