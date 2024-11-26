package nextstep.laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> participants) {
        this.participants = participants
                .stream().map(Participant::new).collect(Collectors.toList());
    }

    public List<Participant> values() {
        return participants;
    }
}
