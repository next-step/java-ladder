package nextstep.ladder.domain;

import org.apache.commons.lang3.StringUtils;

public class Player {

    private static final Integer MAXIMUM_USER_NAME_LENGTH = 5;
    private static final String INVALID_USER_NAME_EXCEPTION_MESSAGE = "이름은 길이는 최대 5글자 입니다.";

    private String userName;

    private Player(String userName) {
        validateUserName(userName);
        this.userName = userName;
    }

    private void validateUserName(String userName) {
        if (userName.length() > MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_USER_NAME_EXCEPTION_MESSAGE);
        }
    }

    public String convertUserNameWithLeftPad() {
        return StringUtils.leftPad(this.userName, MAXIMUM_USER_NAME_LENGTH + 1);
    }

    public static Player of(String userName) {
        return new Player(userName);
    }
}
