package nextstep.ladder.domain;

import nextstep.ladder.constant.LadderConstants;
import org.apache.commons.lang3.StringUtils;

public class Player {

    private String userName;

    private Player(String userName) {
        this.userName = userName;
    }

    public static Player of(String userName) {
        validateUserName(userName);
        return new Player(userName);
    }

    public String convertUserNameWithLeftPad() {
        return StringUtils.leftPad(this.userName, LadderConstants.MAXIMUM_USER_NAME_LENGTH + 1);
    }
    
    private static void validateUserName(String userName) {
        if (userName.length() > LadderConstants.MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException(LadderConstants.INVALID_USER_NAME_EXCEPTION_MESSAGE);
        }
    }
}
