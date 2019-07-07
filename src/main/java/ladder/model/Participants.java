package ladder.model;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> names) {
        participants = names.stream()
                            .map(Participant::new)
                            .collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
