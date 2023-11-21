package nextstep.ladder.domain;


import java.util.List;

public class Ladder {
    private Participants participants;
    private Lines lines;

    public Ladder(final Participants participants, final int ladderHeight) {
        this.participants = participants;
        this.lines = new Lines(participants.countOfPerson(), ladderHeight);
    }
}
