package ladder.engine;

import ladder.gilbert.domain.data.Goals;
import ladder.gilbert.domain.data.LadderHeight;


public interface LadderGenerator {

    Ladder generate(Goals goals, LadderHeight ladderHeight);

}
