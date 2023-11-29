package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final int MIN_PARTICIPANT = 2;
    private List<Name> participant;

    public Participants(String value) {
        participant = new ArrayList<>();
        List<String> names = Parser.splitString(value);
        validateParticipantCount(names.size());
        names.stream()
                .forEach(name -> participant.add(new Name(name)));
    }

    public int size() {
        return participant.size();
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
