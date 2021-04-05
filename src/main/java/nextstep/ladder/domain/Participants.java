package nextstep.ladder.domain;

import java.util.List;

public class Participants {

    private List<Participant> participants;

    private Participants(final List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(final List<Participant> participants) {
        return new Participants(participants);
    }
}
