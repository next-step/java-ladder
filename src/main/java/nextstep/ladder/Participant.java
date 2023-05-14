package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Participant {

    private List<Name> participants;

    public Participant(String... names) {
        participants = new ArrayList<>();
        for (String name : names) {
            this.participants.add(new Name(name));
        }
    }

    public List<Name> getParticipants() {
        return participants;
    }

    public int getParticipantSize(){
        return participants.size();
    }
}
