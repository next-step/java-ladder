package nextstep.ladder.domain.participant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Participants {

    private List<Participant> participants = new ArrayList<>();

    public Participants(List<Participant> participants) {
        this.participants.addAll(participants);
    }

    public Stream<Participant> stream() {
        return participants.stream();
    }
}
