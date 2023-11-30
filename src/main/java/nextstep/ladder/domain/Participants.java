package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final int MIN_PARTICIPANT = 2;
    private List<Name> participant;

    public Participants(List<String> names) {
        participant = new ArrayList<>();
        validateParticipantCount(names.size());
        names.stream()
                .forEach(name -> participant.add(new Name(name)));
    }

    public int ladderSpace() {
        return participant.size() - 1;
    }

    public List<Name> getParticipant() {
        return Collections.unmodifiableList(participant);
    }

    private void validateParticipantCount(int participantCount) {
        if (participantCount < MIN_PARTICIPANT) {
            throw new IllegalArgumentException("최소 2명 이상 참가해야됩니다.");
        }
    }
}
