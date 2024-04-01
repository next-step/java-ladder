package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(List<String> participants) {
        List<Participant> pluralParticipants = participants.stream()
                .map(Participant::of)
                .collect(Collectors.toList());

        return new Participants(pluralParticipants);
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
