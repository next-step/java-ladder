package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Participants {
    private final List<Participant> participants;

    public Participants(List<String> participantNames) {
        this.participants = join(participantNames);
    }

    private List<Participant> join(List<String> participantNames) {
        return participantNames
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return participants.size();
    }
}
