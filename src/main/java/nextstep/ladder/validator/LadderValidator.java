package nextstep.ladder.validator;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.exception.LadderHeightException;

public class LadderValidator {

    public static void validateLadderMaxHeight(int height) throws LadderHeightException {
        if (height < Ladder.MIN_LADDER_HEIGHT) {
            throw new LadderHeightException(height);
        }
    }

}
