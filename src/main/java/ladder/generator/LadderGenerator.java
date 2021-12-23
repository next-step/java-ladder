package ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;

public interface LadderGenerator extends Generator {

    Ladder generate(int countOfPlayer, LadderHeight height);

}
