package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(String text) {
        this.participants = Arrays.stream(text.split(","))
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return this.participants.size();
    }

    public List<String> getParticipantNames() {
        return Collections.unmodifiableList(this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList()));
    }
}
