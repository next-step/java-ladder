package ladder.model;

import java.util.List;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants create(List<Participant> participants) {
        return new Participants(participants);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public int size() {
        return participants.size();
    }
}
