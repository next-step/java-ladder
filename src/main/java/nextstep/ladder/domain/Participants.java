package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final List<String> participants;

    public Participants(List<String> participants) {
        this.participants = participants;
    }

    public int getParticipantCount() {
        return participants.size();
    }

    public List<String> getParticipants() {
        return new ArrayList<>(participants);
    }

}
