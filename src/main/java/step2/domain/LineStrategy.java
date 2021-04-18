package step2.domain;

import static step2.domain.LadderType.EMPTY;
import static step2.domain.LadderType.LEFT;
import static step2.domain.LadderType.RIGHT;

public interface LineStrategy {

    LadderType firstPoint();

    LadderType next(LadderType prev);

    default LadderType last(LadderType prev){
        if (prev == RIGHT) {
            return LEFT;
        }
        return EMPTY;
    }
}
