package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class LadderUsersMismatchException extends RuntimeException {

    public LadderUsersMismatchException(Object userSize, Object resultSize) {
        super(MessageFormat.format("{0} 사용자 인원: {1},결과 개수 {2}", "사용자와 결과 개수는 일치해야 합니다", userSize,
            resultSize));
    }
}
