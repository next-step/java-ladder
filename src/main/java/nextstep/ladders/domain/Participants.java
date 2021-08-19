package nextstep.ladders.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private List<Participant> participants;

    public Participants(final List<String> names) {
        this.participants = names.stream()
                .map(Participant::valueOf)
                .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int count() {
        return participants.size();
    }
}
