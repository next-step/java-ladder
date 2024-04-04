package nextstep.ladder.error.exception;

import java.text.MessageFormat;
import nextstep.ladder.common.Constants;

public class UserNameSizeException extends RuntimeException {

    public UserNameSizeException(Object parameter) {
        super(MessageFormat.format("{0} {1}입니다. 입력값: {2}", "UserName의 최대 크기는",
            Constants.USER_NAME_LIMIT_SIZE,
            parameter));
    }
}
