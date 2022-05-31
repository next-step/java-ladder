package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final List<Participant> participants;

    public Participants(String[] participants) {
        List<Participant> inputParticipants = new ArrayList<>();
        for (String participant : participants) {
            inputParticipants.add(new Participant(participant));
        }

        this.participants = inputParticipants;
    }

    public int numberOfParticipants() {
        return this.participants.size();
    }
}
