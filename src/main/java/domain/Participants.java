package domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public Position initialPosition (Participant participant) {
        if (!participants.contains(participant)) {
            throw new NoSuchElementException("There is no participant having that name");
        }
        return new Position(participants.indexOf(participant));
    }

    public List<String> getNamesOfParticipants() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
