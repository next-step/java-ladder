package ladder.domain.ladder;

import ladder.domain.rule.RandomGenerator;
import ladder.domain.user.Participants;

import java.util.Objects;

public class LadderContext {

    private final Ladder ladder;

    public LadderContext(int ladderHeight, int numberOfParticipant) {
        this.ladder = new LadderGenerator(new RandomGenerator()).generate(ladderHeight, numberOfParticipant);
    }

    public int ladderHeight() {
        return ladder.size();
    }

    public int lineSize() {
        return ladder.lineSize();
    }

    public boolean isRight(int lineIndex, int pointIndex) {
        return ladder.isRight(lineIndex, pointIndex);
    }

    LadderResult play(InputLadderResult inputLadderResult, Participants participants) {
        return ladder.play(inputLadderResult, participants);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderContext that = (LadderContext) o;
        return Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
