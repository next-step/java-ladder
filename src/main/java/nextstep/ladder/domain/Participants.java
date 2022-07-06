package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Participants {
    private final List<Participant> participants;

    public Participants(String[] participants) {
        this.participants = new ArrayList<>();
        for (String participant : participants) {
            this.participants.add(new Participant(participant));
        }
    }

    public int numberOfParticipants() {
        return this.participants.size();
    }

    public List<Participant> value() {
        return Collections.unmodifiableList(participants);
    }

    public String findByName(String name) {
        return this.participants.stream().filter(participant -> participant.name() == name).findFirst().get().name();
    }
}
