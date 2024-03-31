package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class LadderHeightSizeException extends RuntimeException {

    public LadderHeightSizeException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "사다리의 높이는 0보다 커야 합니다",
            parameter));
    }
}
