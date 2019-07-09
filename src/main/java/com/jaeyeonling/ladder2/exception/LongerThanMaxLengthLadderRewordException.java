package com.jaeyeonling.ladder2.exception;

import com.jaeyeonling.ladder2.domain.reword.LadderReword;

public class LongerThanMaxLengthLadderRewordException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "당첨 결과의 길이는 %d를 넘을 수 없습니다. (입력 값: %s)";

    public LongerThanMaxLengthLadderRewordException(final String input) {
        super(String.format(ERROR_MESSAGE, LadderReword.MAX_LENGTH, input));
    }
}
