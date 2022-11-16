package nextstep.ladder.exception;

import nextstep.exception.ErrorCode;
import nextstep.ladder.domain.User;

public enum UserErrorCode implements ErrorCode {

    USER_NAME_LENGTH_BAD_REQUEST("사용자 이름은 " + User.NAME_MAXIMUM_VALUE + "자를 초과할 수 없습니다.");

    private final String message;

    UserErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
