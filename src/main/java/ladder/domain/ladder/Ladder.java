package ladder.domain.ladder;

import ladder.domain.user.Name;
import ladder.domain.user.Participants;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<HorizontalLine> lines;
    private final int numberOfParticipant;

    Ladder(List<HorizontalLine> lines, int numberOfParticipant) {
        this.lines = lines;
        this.numberOfParticipant = numberOfParticipant;
    }

    boolean isRight(int lineIndex, int pointIndex) {
        return lines.get(lineIndex).isRight(pointIndex);
    }

    int size() {
        return lines.size();
    }

    int lineSize() {
        return lines.get(0).size();
    }

    LadderResult play(InputLadderResult inputLadderResult, Participants participants) {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < numberOfParticipant; i++) {
            ladderResult.put(new Name(participants.getName(i).toString()), inputLadderResult.findResult(getResult(i)));
        }
        return ladderResult;
    }

    private int getResult(int index) {
        int position = index;
        for (HorizontalLine line : lines) {
            position = line.move(position);
        }
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
