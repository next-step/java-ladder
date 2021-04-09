package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private List<Participant> participants;

    private Participants(final List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(final List<String> userName) {
        return new Participants(userName.stream()
            .map(Participant::of)
            .collect(Collectors.toList())
        );
    }

    public List<Participant> toList() {
        return participants.stream()
            .collect(Collectors.toList());
    }
}
