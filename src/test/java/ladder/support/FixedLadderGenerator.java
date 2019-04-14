package ladder.support;

import ladder.domain.Ladder;
import ladder.domain.generator.LadderGenerator;

public class FixedLadderGenerator implements LadderGenerator {
    private Ladder ladder;

    public FixedLadderGenerator(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public Ladder generate(int countOfPerson, int height) {
        return ladder;
    }
}
