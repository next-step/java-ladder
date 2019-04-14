package ladder.domain.generator;

import ladder.domain.Ladder;

public interface LadderGenerator {
    Ladder generate(int countOfPerson, int height);
}
