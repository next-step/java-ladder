package generator.ladder;

import domain.ladder.Ladder;

public interface LadderGenerator {

    Ladder generate(int lineSize);
}
