package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class UserNameEmptyException extends RuntimeException {

    public UserNameEmptyException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "UserName은 null이거나 빈 값일수 없습니다.",
            parameter));
    }
}
