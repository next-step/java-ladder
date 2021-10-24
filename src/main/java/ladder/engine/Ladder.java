package ladder.engine;

import ladder.domain.Lines;
import ladder.domain.Users;

public interface Ladder {
    LadderResult play(Users users);
    Lines lines();
}
