package ladder.domain.ladder;

import ladder.domain.participant.Participants;
import ladder.exception.InsufficientLadderHeightException;

import java.util.List;

public class Ladder {

    private static final int MIN_LADDER_HEIGHT = 2;
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        if (lines.size() < MIN_LADDER_HEIGHT) {
            throw new InsufficientLadderHeightException();
        }
        this.lines = lines;
    }

    public int sizeHeight() {
        return lines.size();
    }

    public int sizeWidth() {
        return lines.get(0).sizeWidth();
    }

    public List<Boolean> getLine(int index) {
        return lines.get(index).getPoints();
    }

    public void movePosition(int step, Participants participants) {
        for (int i = 0; i < participants.countParticipant(); i++) {
            int direction = lines.get(step).giveDirection(participants.findRowByParticipant(participants.getParticipant(i)));
            participants.getParticipant(i).movePosition(direction);
        }
    }
}
