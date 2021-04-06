package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private List<Participant> participants;

    private Participants(final List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(final String[] userName) {
        return new Participants(Arrays.stream(userName)
                .map(Participant::of)
                .collect(Collectors.toList())
        );
    }
}
