package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class NotExistUserException extends RuntimeException {

    public NotExistUserException(Object parameter) {
        super(MessageFormat.format("{0}. 입력값: {1}", "존재하지 않는 사용자입니다", parameter));
    }
}
