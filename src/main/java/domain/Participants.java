package domain;

import java.util.ArrayList;
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

    public int initialPosition(String name) {
        if (!participants.contains(new Participant(name))) {
            throw new NoSuchElementException("There is no participant with that name.");
        }
        return participants.indexOf(new Participant(name));
    }

    public List<String> getNamesOfParticipants() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public static Participants of(List<String> names) {
        List<Participant> participants = new ArrayList<>();

        names.forEach(name -> participants.add(new Participant(name)));

        return new Participants(participants);
    }
}
