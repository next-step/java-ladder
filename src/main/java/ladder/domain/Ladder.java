package ladder.domain;

import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final Participants participants;

    public Ladder(List<Line> lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Participants getParticipants() {
        return participants;
    }
}
