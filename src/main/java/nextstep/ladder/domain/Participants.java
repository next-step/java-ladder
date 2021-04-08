package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Stream<Participant> stream() {
        return participants.stream();
    }
}
