package ladder.exception;

import ladder.domain.user.User;

public class GreaterThenMaxUserNameException extends IllegalArgumentException {

    private static final String MESSAGE = "유저의 이름은 %d자 이하로 입력해 주세요.";

    public GreaterThenMaxUserNameException() {
        super(String.format(MESSAGE, User.MAX_NAME_LENGTH));
    }
}
