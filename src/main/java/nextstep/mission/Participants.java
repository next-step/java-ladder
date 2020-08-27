package nextstep.mission;

import java.util.List;

public class Participants {

    private List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }
}
