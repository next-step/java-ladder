package ladder.domain.ladder;

import ladder.domain.rule.RandomGenerator;

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
}
