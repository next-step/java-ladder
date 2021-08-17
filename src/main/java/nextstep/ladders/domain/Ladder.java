package nextstep.ladders.domain;

import java.util.List;

public class Ladder {

    private final Participants participants;
    private final Lines lines;

    public Ladder(final Participants participants, final Lines lines) {
        this.participants = participants;
        this.lines = lines;
    }

    public Ladder(final List<String> names, final int height) {
        this.participants = new Participants(names);
        this.lines = new Lines(names.size(), height);
    }

    public Lines getLines() {
        return lines;
    }

    public Participants getParticipants() {
        return participants;
    }
}
