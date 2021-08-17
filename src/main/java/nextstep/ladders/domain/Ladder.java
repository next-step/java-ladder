package nextstep.ladders.domain;

public class Ladder {

    private final Participants participants;
    private final Lines lines;

    public Ladder(final Participants participants, final Lines lines) {
        this.participants = participants;
        this.lines = lines;
    }

    public Lines getLines() {
        return lines;
    }
}
