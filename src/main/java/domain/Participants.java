package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public List<String> getNamesOfParticipants() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
