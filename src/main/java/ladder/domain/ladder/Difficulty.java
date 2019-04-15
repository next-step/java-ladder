package ladder.domain.ladder;

import ladder.domain.ladder.generator.DirectionGenerator;
import ladder.domain.ladder.generator.EasyDirectionGenerator;
import ladder.domain.ladder.generator.HardDirectionGenerator;
import ladder.domain.ladder.generator.NormalDirectionGenerator;

public enum Difficulty {

    HARD(15, new HardDirectionGenerator()),
    NORMAL(10, new NormalDirectionGenerator()),
    EASY(5, new EasyDirectionGenerator());

    private final int ladderHeight;
    private final DirectionGenerator directionGenerator;

    Difficulty(int ladderHeight, DirectionGenerator directionGenerator) {
        this.ladderHeight = ladderHeight;
        this.directionGenerator = directionGenerator;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public DirectionGenerator getDirectionGenerator() {
        return directionGenerator;
    }
}
