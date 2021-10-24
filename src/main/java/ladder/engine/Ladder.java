package ladder.engine;

import ladder.domain.Lines;
import ladder.domain.Users;

public interface Ladder {

    Users start();
    LadderResult play(Users users);
    Lines lines();


}
