package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class UserNameSizeException extends RuntimeException {

    public UserNameSizeException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "UserName의 최대 크기는 5입니다.",
            parameter));
    }
}
