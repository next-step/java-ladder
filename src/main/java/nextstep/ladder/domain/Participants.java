package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final int MIN_PARTICIPANTS = 2;
    private List<Name> participants;

    public Participants(List<String> names) {
        participants = new ArrayList<>();
        validateParticipantCount(names.size());
        names.stream()
                .forEach(name -> participants.add(new Name(name)));
    }

    public int size() {
        return participants.size();
    }

    public List<Name> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public boolean isParticipants(String participant) {
        return participants.contains(new Name(participant));
    }

    private void validateParticipantCount(int participantCount) {
        if (participantCount < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException("최소 2명 이상 참가해야됩니다.");
        }
    }
}
