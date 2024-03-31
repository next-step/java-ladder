package nextstep.ladder.error.exception;

import java.text.MessageFormat;

public class UserSizeEmptyException extends RuntimeException {

    public UserSizeEmptyException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "등록된 사용자가 존재하지 않습니다",
            parameter));
    }
}
