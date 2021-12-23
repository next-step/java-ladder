package ladder.generator;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Line;

public interface Generator {

    Ladder generate(int countOfPlayer, LadderHeight height);
    Line generate(int countOfPlayer);

}
