package ladder.generator;

import ladder.domain.ladder.Ladder;

@FunctionalInterface
public interface LadderGenerator {

    Ladder generate(int countOfPlayer);

}
