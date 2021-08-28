package nextstep.ladder.domain.participant;

import java.util.List;
import java.util.stream.Stream;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Stream<Participant> stream() {
        return participants.stream();
    }

    public int size() {
        return participants.size();
    }
}
