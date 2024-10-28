package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final LadderCount ladderCount;
    private final Participants participants;
    private List<Line> lines;

    public Ladder(String participant, String ladderCount) {
        this.ladderCount = new LadderCount(ladderCount);
        this.participants = new Participants(participant);
        initializeLines();
    }

    private void initializeLines() {
        lines = new ArrayList<>();
        for (int i = 0; i < ladderCount.getLadderCount(); i++) {
            lines.add(new Line(participants.getParticipants().size()));
        }
    }

    public void createLines() {
        for (Line line : lines) {
            line.createLine(ladderCount.getLadderCount());
        }
    }

    public List<Participant> getParticipants() {
        return participants.getParticipants();
    }

    public List<Line> getLines() {
        return lines;
    }
}
