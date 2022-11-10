package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

public class Height {
    public Height(int height) {
        if(height < 1) {
            throw new LadderGameException(ErrorCode.HEIGHT_UNDER_MINIMUM);
        }
    }
}
