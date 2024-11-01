package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<String> names() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public int size() {
        return participants.size();
    }
}
