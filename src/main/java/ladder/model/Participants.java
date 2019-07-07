package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> names) {
        participants = names.stream()
                            .map(Participant::new)
                            .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
