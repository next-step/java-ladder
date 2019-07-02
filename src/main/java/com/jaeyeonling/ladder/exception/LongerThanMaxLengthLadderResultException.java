package com.jaeyeonling.ladder.exception;

import com.jaeyeonling.ladder.domain.ladder.LadderResult;

public class LongerThanMaxLengthLadderResultException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "당첨 결과의 길이는 %d를 넘을 수 없습니다. (입력 값: %s)";

    public LongerThanMaxLengthLadderResultException(final String input) {
        super(String.format(ERROR_MESSAGE, LadderResult.MAX_LENGTH, input));
    }
}
