package ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(int countOfPlayer, LadderHeight height);

}
